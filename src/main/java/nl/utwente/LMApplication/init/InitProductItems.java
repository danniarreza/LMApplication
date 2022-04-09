package nl.utwente.LMApplication.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.utwente.LMApplication.model.Inventory;
import nl.utwente.LMApplication.model.Product;
import nl.utwente.LMApplication.repository.InventoryRepository;
import nl.utwente.LMApplication.repository.ProductRepository;

@Component
public class InitProductItems {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @PostConstruct
    public void init(){

        Product product1 = new Product(1, "Chicken", "pcs");
        Product product2 = new Product(2, "Bread", "pcs");

        productRepository.save(product1);
        productRepository.save(product2);

        inventoryRepository.save(new Inventory(1, product1, 50));
        inventoryRepository.save(new Inventory(2, product2, 100));        
    }
}
