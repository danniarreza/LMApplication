package nl.utwente.LMApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import nl.utwente.LMApplication.model.Product;
import nl.utwente.LMApplication.model.TransportOrder;

@RestController
@Tag(name = "Transport Order", description = "This is the Transport Order REST API")
public class TransportOrderController {
    
    @GetMapping("/transportOrder/{id}")
    public TransportOrder getSalesOrder(@PathVariable int id){
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1, "Chicken", 10));
        productList.add(new Product(2, "Tomato", 10));
        productList.add(new Product(3, "Bread", 10));

        TransportOrder salesOrder = new TransportOrder(id, "Johny", productList);
        
        return salesOrder;
    }

    @GetMapping("/transportOrder")
    public List<TransportOrder> getAllSalesOrders(){

        List<TransportOrder> transportOrderList = new ArrayList<TransportOrder>();
        
        for (int i = 0; i < 3; i++) {

            List<Product> productList = new ArrayList<Product>();
            productList.add(new Product(1, "Chicken", 10));
            productList.add(new Product(2, "Tomato", 10));
            productList.add(new Product(3, "Bread", 10));

            TransportOrder salesOrder = new TransportOrder((i+1), "Marry", productList);
            transportOrderList.add(salesOrder);
        }

        return transportOrderList;
    }

    @PostMapping("/transportOrder")
    public TransportOrder createSalesOrder(@RequestBody TransportOrder salesOrder){
        
        return salesOrder;
    }

    @PutMapping("/transportOrder")
    public TransportOrder updateSalesOrder(@RequestBody TransportOrder salesOrder){

        return salesOrder;
    }

    @DeleteMapping("/transportOrder/{id}")
    public int deleteSalesOrder(@PathVariable int id){

        return id;
    }

}
