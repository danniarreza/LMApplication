package nl.utwente.LMApplication.model;

public class PurchaseRequest {
    private int purchaseRequestId;
    private Product product;
    private int amount;
    private int counter = 1;

    public PurchaseRequest(Product product, int amount) {
        this.purchaseRequestId = counter;
        this.product = product;
        this.amount = amount;
        counter++;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPurchaseRequestId() {
        return purchaseRequestId;
    }

    public void setPurchaseRequestId(int purchaseRequestId) {
        this.purchaseRequestId = purchaseRequestId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
