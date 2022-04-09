package nl.utwente.LMApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import nl.utwente.LMApplication.model.Inventory;
import nl.utwente.LMApplication.model.Product;
import nl.utwente.LMApplication.repository.InventoryRepository;
import nl.utwente.LMApplication.repository.ProductRepository;

@RestController
@Tag(name = "Product", description = "This is the Product REST API")
public class ProductController {

    @Autowired ProductRepository productRepository;
    @Autowired InventoryRepository inventoryRepository;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id){

        Product product = productRepository.findById(id).orElse(null);

        return product;
    }

    @GetMapping("/product/{id}/inventory")
    public Inventory getProductInventory(@PathVariable int id){

        Product product = productRepository.findById(id).orElse(null);
     
        Inventory inventory = inventoryRepository.findByProduct(product); 
        return inventory;
    }

    @GetMapping("/product")
    public List<Product> getAllProduct(){

        List<Product> productList = productRepository.findAll();
        
        return productList;
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product){
        productRepository.save(product);
        return product;
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){

        Product existingProduct = productRepository.findById(product.getProductId()).orElse(null);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductUnit(product.getProductUnit());

        productRepository.save(product);
        return product;
    }

    @DeleteMapping("/product")
    public int deleteProduct(@PathVariable int id){
        productRepository.deleteById(id);
        return id;
    }
}
