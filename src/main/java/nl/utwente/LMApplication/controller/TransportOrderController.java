package nl.utwente.LMApplication.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import nl.utwente.LMApplication.model.Goods;
import nl.utwente.LMApplication.model.Inventory;
import nl.utwente.LMApplication.model.Product;
import nl.utwente.LMApplication.model.PurchaseRequest;
import nl.utwente.LMApplication.model.TransportOrder;
import nl.utwente.LMApplication.publisher.MessagePublisher;
import nl.utwente.LMApplication.repository.GoodsRepository;
import nl.utwente.LMApplication.repository.InventoryRepository;
import nl.utwente.LMApplication.repository.ProductRepository;
import nl.utwente.LMApplication.repository.PurchaseRequestRepository;
import nl.utwente.LMApplication.repository.TransportOrderRepository;
import nl.utwente.LMApplication.service.TransportOrderService;

@RestController
@Tag(name = "Transport Order", description = "This is the Transport Order REST API")
public class TransportOrderController {

    @Autowired
    TransportOrderRepository transportOrderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    PurchaseRequestRepository purchaseRequestRepository;
    @Autowired
    TransportOrderService transportOrderService;
    @Autowired
    GoodsRepository goodsRepository;

    @PostMapping("/transportOrder")
    public TransportOrder createTransportOrder(@RequestBody TransportOrder transportOrder) {
        // initiate check inventory, get all goods in the new transport order
        List<Goods> goodsList = transportOrder.getGoodsList();
        List<Goods> updatedGoodsList = new ArrayList<>();

        for (Goods goods : goodsList) {
            // for every goods, check if the product and inventory existed in database;
            Product goodsProduct = goods.getProduct();
            Product product = productRepository.findById(goodsProduct.getProductId()).orElse(null);

            // if the product does not exist yet, create a product;
            if (product == null) {
                product = goodsProduct;
                productRepository.save(product);
            }

            goods.setProduct(product);
            goods = goodsRepository.save(goods);
            updatedGoodsList.add(goods);
            
            // append updated goodslist to the sales order
            transportOrder.setGoodsList(updatedGoodsList);

            Inventory inventory = inventoryRepository.findByProduct(product);
            // if the inventory does not exist yet, create the inventory of that product
            if (inventory == null) {
                inventory = new Inventory(0, product, 0);
                inventoryRepository.save(inventory);
            }

            // for every goods, check if the inventory of the product is depleted
            if (inventory.getAmount() < goods.getAmount()) {
                // if it's depleted, create purchase order
                PurchaseRequest purchaseRequest = new PurchaseRequest(product, goods.getAmount() * 3);
                purchaseRequestRepository.save(purchaseRequest);

                // update the amount of the product's inventory amount
                inventory.setAmount(inventory.getAmount() + purchaseRequest.getAmount());
            }

            // then perform the inventory amount substraction based on the order's goods
            // amount
            inventory.setAmount(inventory.getAmount() - goods.getAmount());
        }
        // schedule the pickup time of the transport order
        schedulePickupTime(transportOrder);

        // calculate the order weight of the transport order
        calculateOrderWeight(transportOrder);

        // save the new transport order in database
        transportOrderRepository.save(transportOrder);
        return transportOrder;
    }

    @GetMapping("/transportOrder/{id}")
    public TransportOrder getTransportOrder(@PathVariable int id) {
        TransportOrder transportOrder = transportOrderRepository.findById(id).orElse(null);

        return transportOrder;
    }

    @GetMapping("/transportOrder")
    public List<TransportOrder> getAllTransportOrders() {

        List<TransportOrder> transportOrderList = transportOrderRepository.findAll();

        return transportOrderList;
    }

    @PutMapping("/transportOrder")
    public TransportOrder updateTransportOrder(@RequestBody TransportOrder transportOrder) {

        transportOrderRepository.save(transportOrder);

        // test update transport order confirmed delivery date!!
        transportOrderService.updateTransportOrder(transportOrder);

        return transportOrder;
    }

    @GetMapping("/transportOrder/{transportOrderId}/notifyUpdate")
    public TransportOrder notifyUpdateTransportOrder(@PathVariable int transportOrderId) {

        TransportOrder existingTransportOrder = transportOrderRepository.findById(transportOrderId).orElse(null);

        // test update transport order confirmed delivery date!!
        transportOrderService.updateTransportOrder(existingTransportOrder);

        return existingTransportOrder;
    }

    @DeleteMapping("/transportOrder/{id}")
    public int deleteTransportOrder(@PathVariable int id) {

        return id;
    }

    // -------------------------------------------------------------------------------------

    public void schedulePickupTime(TransportOrder transportOrder) {
        transportOrder.setPickupDate(DateUtils.addHours(transportOrder.getCreationDate(), 24));
    }

    public double calculateOrderWeight(TransportOrder transportOrder) {
        double totalWeight = 0;
        transportOrder.setOrderWeight(random(1000, 3000));
        return totalWeight;
    }

    public int random(int i, int j) {
        Random r = new Random();
        int result = r.nextInt(j - i) + i;
        return result;
    }

    // we have added this part to trigger the messageProducer
    @Autowired
    @Lazy(true)
    private MessagePublisher messagePublisher;

    @GetMapping("/transportOrderPublish/{transportOrderId}")
    public void publishTransportRequest(@PathVariable int transportOrderId) {

        TransportOrder existingTransportOrder = transportOrderRepository.findById(transportOrderId).orElse(null);

        Map<String, Object> transportOrder = new HashMap<>();
        transportOrder.put("transportOrderId", existingTransportOrder.getTransportOrderId());
        transportOrder.put("branchId", existingTransportOrder.getBranchId());
        transportOrder.put("orderWeight", existingTransportOrder.getOrderWeight());
        transportOrder.put("creationDate", existingTransportOrder.getCreationDate());
        transportOrder.put("proposedDeliveryDate", existingTransportOrder.getProposedDeliveryDate());
        transportOrder.put("pickupDate", existingTransportOrder.getPickupDate());
        transportOrder.put("status", existingTransportOrder.getStatus());
        String message = transportOrder.toString();
        messagePublisher.sendMessage(message);
    }

}
