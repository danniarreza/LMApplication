package nl.utwente.LMApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import nl.utwente.LMApplication.repository.InventoryRepository;
import nl.utwente.LMApplication.repository.ProductRepository;
import nl.utwente.LMApplication.repository.PurchaseRequestRepository;
import nl.utwente.LMApplication.repository.TransportOrderRepository;
import nl.utwente.LMApplication.service.TransportOrderService;


@RestController
@Tag(name = "Transport Order", description = "This is the Transport Order REST API")
public class TransportOrderController {

    @Autowired TransportOrderRepository transportOrderRepository;
    @Autowired ProductRepository productRepository;
    @Autowired InventoryRepository inventoryRepository;
    @Autowired PurchaseRequestRepository purchaseRequestRepository;

    @Autowired TransportOrderService transportOrderService;

    @PostMapping("/transportOrder")
    public TransportOrder createTransportOrder(@RequestBody TransportOrder transportOrder){
        // initiate check inventory, get all goods in the new transport order
        List<Goods> goodsList = transportOrder.getGoodsList();

        for (Goods goods : goodsList) {
            // for every goods, check if the product and inventory existed in database;
            Product goodsProduct = goods.getProduct();
            Product product = productRepository.getProduct(goodsProduct.getProductId());
            
            // if the product does not exist yet, create a product;
            if(product == null){
                product = goodsProduct;
                productRepository.createProduct(product);
            }

            Inventory inventory = inventoryRepository.getInventoryByProductId(product.getProductId());
            // if the inventory does not exist yet, create the inventory of that product
            if(inventory == null){
                inventory = new Inventory(0, product, 0);
                inventoryRepository.createInventory(inventory);
            }

            // for every goods, check if the inventory of the product is depleted  
            if(inventory.getAmount() < goods.getAmount()){
                // if it's depleted, create purchase order
                PurchaseRequest purchaseRequest = new PurchaseRequest(product, goods.getAmount() * 3);
                purchaseRequestRepository.createPurchaseRequest(purchaseRequest);

                // update the amount of the product's inventory amount 
                inventory.setAmount(inventory.getAmount() + purchaseRequest.getAmount());
            }
            
            // then perform the inventory amount substraction based on the order's goods amount
            inventory.setAmount(inventory.getAmount() - goods.getAmount());
        }
        // schedule the pickup time of the transport order
        schedulePickupTime(transportOrder);

        // save the new transport order in database
        transportOrderRepository.createTransportOrder(transportOrder);
        return transportOrder;
    }

    @GetMapping("/transportOrder/{id}")
    public TransportOrder getTransportOrder(@PathVariable int id){
        TransportOrder transportOrder = transportOrderRepository.getTransportOrder(id);
        
        return transportOrder;
    }

    @GetMapping("/transportOrder")
    public List<TransportOrder> getAllTransportOrders(){

        List<TransportOrder> transportOrderList = transportOrderRepository.getTransportOrderAll();

        return transportOrderList;
    }


    @PutMapping("/transportOrder")
    public TransportOrder updateTransportOrder(@RequestBody TransportOrder transportOrder){

        transportOrderRepository.updateTransportOrder(transportOrder);

        // test update tranport order confirmed delivery date!!
        transportOrderService.updateTransportOrder(transportOrder);

        return transportOrder;
    }

    @DeleteMapping("/transportOrder/{id}")
    public int deleteTransportOrder(@PathVariable int id){

        return id;
    }

    // ------------------------------------------------------------------------------------- 

    public void receiveNewOrders(){
        //Must return TransportOrder not void
     }
 

    public void schedulePickupTime(TransportOrder transportOrder){
        transportOrder.setPickupDate( DateUtils.addHours(transportOrder.getCreationDate(),24));
    }
    public void sendTruckRequest(){

    }
    public void receivePickupResponse(){

    }
    // public void calculateWeight(TransportOrder transportOrder){
    //     double totalWeight = 0;
    //     for (Product p: transportOrder.getProductList())
    //     {
    //         totalWeight = totalWeight + (p.getProductQuantity() * p.getProductWeightPerUnit() );
    //     }
    // transportOrder.setOrderWeight(totalWeight);
    // }

    public void sendConfirmedDelivery(){

    }


}
