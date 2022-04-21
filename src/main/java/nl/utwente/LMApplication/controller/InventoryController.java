package nl.utwente.LMApplication.controller;

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
import nl.utwente.LMApplication.repository.InventoryRepository;

@RestController
@Tag(name = "Inventory", description = "This is the Inventory REST API")
public class InventoryController {

    @Autowired InventoryRepository inventoryRepository;

    @GetMapping("/inventory/{id}")
    public Inventory getInventory(@PathVariable int id){

        Inventory inventory = inventoryRepository.findById(id).orElse(null);

        return inventory;
    }

    @GetMapping("/inventory")
    public List<Inventory> getAllInventory(){

        List<Inventory> inventoryList = inventoryRepository.findAll();
        
        return inventoryList;
    }

    @PostMapping("/inventory")
    public Inventory createInventory(@RequestBody Inventory inventory){
        inventoryRepository.save(inventory);

        return inventory;
    }

    @PutMapping("/inventory")
    public Inventory updateInventory(@RequestBody Inventory inventory){

        return inventory;
    }

    @DeleteMapping("/inventory")
    public int deleteInventory(@PathVariable int id){

        inventoryRepository.deleteById(id);
        return id;
    }
    
}
