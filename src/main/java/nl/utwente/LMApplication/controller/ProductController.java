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
import nl.utwente.LMApplication.model.Product;
import nl.utwente.LMApplication.repository.ProductRepository;

@RestController
@Tag(name = "Product", description = "This is the Product REST API")
public class ProductController {

    @Autowired ProductRepository productRepository;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id){
        // Product product = new Product("Chicken", "kg");

        Product product = productRepository.getProduct(id);

        return product;
    }

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        // List<Product> productList = new ArrayList<Product>();

        // for (int i = 0; i < 3; i++) {
        //     Product product = new Product("Chicken", "kg");
        //     productList.add(product);
        // }

        List<Product> productList = productRepository.getProductsAll();
        
        return productList;
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product){
        productRepository.createProduct(product);
        return product;
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        productRepository.updateProduct(product);
        return product;
    }

    @DeleteMapping("/product")
    public int deleteProduct(@PathVariable int id){
        productRepository.deleteProduct(id);
        return id;
    }
}
