package nl.utwente.LMApplication.controller;

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
import nl.utwente.LMApplication.model.PurchaseRequest;
import nl.utwente.LMApplication.repository.PurchaseRequestRepository;
import nl.utwente.LMApplication.model.PurchaseRequest;

@RestController
@Tag(name = "Purchase Request", description = "This is the Purchase Request REST API")
public class PurchaseRequestController {

    // public void checkInventory(PurchaseRequest purchaseRequest){
    //     purchaseRequest.setInventoryAfterThisOrder((purchaseRequest.getCurrentInventory() - purchaseRequest.getPurchaseRequestWeightPerUnit()));
    //     if (purchaseRequest.getInventoryAfterThisOrder() < purchaseRequest.getSafetyStock()) {
    //         var purchaseRequest = new PurchaseRequest(purchaseRequest);
    //     }

    // }

    @Autowired PurchaseRequestRepository purchaseRequestRepository;

    @GetMapping("/purchaseRequest/{id}")
    public PurchaseRequest getPurchaseRequest(@PathVariable int id){
        // PurchaseRequest purchaseRequest = new PurchaseRequest("Chicken", "kg");

        PurchaseRequest purchaseRequest = purchaseRequestRepository.getPurchaseRequest(id);

        return purchaseRequest;
    }

    @GetMapping("/purchaseRequest")
    public List<PurchaseRequest> getAllPurchaseRequest(){
        // List<PurchaseRequest> purchaseRequestList = new ArrayList<PurchaseRequest>();

        // for (int i = 0; i < 3; i++) {
        //     PurchaseRequest purchaseRequest = new PurchaseRequest("Chicken", "kg");
        //     purchaseRequestList.add(purchaseRequest);
        // }

        List<PurchaseRequest> purchaseRequestList = purchaseRequestRepository.getPurchaseRequestsAll();
        
        return purchaseRequestList;
    }

    @PostMapping("/purchaseRequest")
    public PurchaseRequest createPurchaseRequest(@RequestBody PurchaseRequest purchaseRequest){
        purchaseRequestRepository.createPurchaseRequest(purchaseRequest);
        return purchaseRequest;
    }

    @PutMapping("/purchaseRequest")
    public PurchaseRequest updatePurchaseRequest(@RequestBody PurchaseRequest purchaseRequest){
        purchaseRequestRepository.updatePurchaseRequest(purchaseRequest);
        return purchaseRequest;
    }

    @DeleteMapping("/purchaseRequest")
    public int deletePurchaseRequest(@PathVariable int id){
        purchaseRequestRepository.deletePurchaseRequest(id);
        return id;
    }


}
