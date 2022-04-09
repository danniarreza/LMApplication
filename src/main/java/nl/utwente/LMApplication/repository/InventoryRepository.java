package nl.utwente.LMApplication.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import nl.utwente.LMApplication.model.Inventory;
import nl.utwente.LMApplication.model.Product;

// @Service
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    public Inventory findByProduct(Product product);
    
    // private static final List<Inventory> inventoryList = new ArrayList<>();
    // private static int idCounter = 1;
    
    // @Autowired ProductRepository productRepository;

    // public Inventory createInventory(Inventory inventory){
    //     inventory.setInventoryId(idCounter++);
    //     inventoryList.add(inventory);
    //     return inventory;
    // }

    // public Inventory updateInventory(Inventory inventory){
    //     inventoryList.add(inventory);
    //     return inventory;
    // }

    // public Inventory getInventory(int id){
    //     for (Inventory inventory : inventoryList) {
    //         if (inventory.getInventoryId() == id){
    //             return inventory;
    //         }
    //     }

    //     return null;
    // }

    // public Inventory getInventoryByProductId(int id){

    //     for (Inventory inventory : inventoryList) {
    //         if (inventory.getProduct().getProductId() == id) {
    //             return inventory;
    //         }
    //     }

    //     return null;
    // }

    // public int deleteInventory(int id){
    //     inventoryList.remove(id);
    //     return id;
    // }

    // public List<Inventory> getInventorysAll(){
    //     return inventoryList;
    // }

}
