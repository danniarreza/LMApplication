package nl.utwente.LMApplication.model;

public class Inventory {

    private int inventoryId;
    private int amount;
    private Product product;

    public Inventory(){}

    public Inventory(int inventoryId, Product product, int amount) {
        this.inventoryId = inventoryId;
        this.product = product;
        this.amount = amount;
    }

    public int getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    
}
