package nl.utwente.LMApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.utwente.LMApplication.model.PurchaseRequest;

// @Service
public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Integer> {
    
    // private static final List<PurchaseRequest> purchaseRequestList = new ArrayList<>();
    // private static int idCounter = 1;

    // public PurchaseRequest createPurchaseRequest(PurchaseRequest purchaseRequest){
    //     purchaseRequest.setPurchaseRequestId(idCounter++);
    //     purchaseRequestList.add(purchaseRequest);
    //     return purchaseRequest;
    // }

    // public PurchaseRequest updatePurchaseRequest(PurchaseRequest purchaseRequest){
    //     purchaseRequestList.add(purchaseRequest);
    //     return purchaseRequest;
    // }

    // public PurchaseRequest getPurchaseRequest(int id){
    //     for (PurchaseRequest purchaseRequest : purchaseRequestList) {
    //         if (purchaseRequest.getPurchaseRequestId() == id){
    //             return purchaseRequest;
    //         }
    //     }

    //     return null;
    // }

    // public PurchaseRequest getPurchaseRequestByProductId(int id){

    //     for (PurchaseRequest purchaseRequest : purchaseRequestList) {
    //         if (purchaseRequest.getProduct().getProductId() == id) {
    //             return purchaseRequest;
    //         }
    //     }

    //     return null;
    // }

    // public int deletePurchaseRequest(int id){
    //     purchaseRequestList.remove(id);
    //     return id;
    // }

    // public List<PurchaseRequest> getPurchaseRequestsAll(){
    //     return purchaseRequestList;
    // }
    
}
