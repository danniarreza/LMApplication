package nl.utwente.LMApplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private Integer productId;
    private String productName;
    private double productQuantity;
    private String productUnit;
    private double productWeightPerUnit;
    private double safetyStock;
    private double inventoryAfterThisOrder;

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductUnit() {
        return this.productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public double getProductWeightPerUnit() {
        return this.productWeightPerUnit;
    }

    public void setProductWeightPerUnit(double productWeightPerUnit) {
        this.productWeightPerUnit = productWeightPerUnit;
    }

    public double getSafetyStock() {
        return this.safetyStock;
    }

    public void setSafetyStock(double safetyStock) {
        this.safetyStock = safetyStock;
    }

    public double getInventoryAfterThisOrder() {
        return this.inventoryAfterThisOrder;
    }

    public void setInventoryAfterThisOrder(double inventoryAfterThisOrder) {
        this.inventoryAfterThisOrder = inventoryAfterThisOrder;
    }

    public Product(Integer productId, String productName, String productUnit) {
        this.productName = productName;
        this.productUnit = productUnit;
        this.productId = productId;
    }

    public Product(){}




    
}
