package nl.utwente.LMApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import nl.utwente.LMApplication.model.Inventory;
import nl.utwente.LMApplication.model.Product;
import nl.utwente.LMApplication.repository.InventoryRepository;

@RestController
@Tag(name = "Inventory", description = "This is the Inventory REST API")
public class InventoryController {

    @Autowired InventoryRepository inventoryRepository;

    @GetMapping("/inventory/{id}")
    public Inventory getInventory(@PathVariable int id){
        // Inventory inventory = new Inventory();

        // Product product = new Product("Chicken", "kg");
        // inventory.setInventoryId(1);
        // inventory.setProduct(product);
        // inventory.setAmount(10);

        Inventory inventory = inventoryRepository.getInventory(id);

        return inventory;
    }

    @GetMapping("/inventory")
    public List<Inventory> getAllInventory(){
        // List<Inventory> inventoryList = new ArrayList<Inventory>();

        // for (int i = 0; i < 3; i++) {
        //     Inventory inventory = new Inventory();

        //     Product product = new Product("Chicken", "kg");
        //     inventory.setInventoryId(1);
        //     inventory.setProduct(product);
        //     inventory.setAmount(10);

        //     inventoryList.add(inventory);
        // }

        List<Inventory> inventoryList = inventoryRepository.getInventorysAll();
        
        return inventoryList;
    }

    @PostMapping("/inventory")
    public Inventory createInventory(@RequestBody Inventory inventory){
        inventoryRepository.createInventory(inventory);

        return inventory;
    }

    @PutMapping("/inventory")
    public Inventory updateInventory(@RequestBody Inventory inventory){

        return inventory;
    }

    @DeleteMapping("/inventory")
    public int deleteInventory(@PathVariable int id){

        inventoryRepository.deleteInventory(id);
        return id;
    }
    
}
