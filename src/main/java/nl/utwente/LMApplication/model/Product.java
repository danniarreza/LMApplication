package nl.utwente.LMApplication.model;

public class Product {

    private int productId;
    private String productName;
    private double productQuantity;
    private String productUnit;
    private double productWeightPerUnit;
    private double safetyStock;
    private double inventoryAfterThisOrder;

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
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

    private int counter = 1;

    public Product(String productName, String productUnit) {
        this.productName = productName;
        this.productUnit = productUnit;
        this.productId = counter;
        counter++;
    }

    public Product(){}




    
}
