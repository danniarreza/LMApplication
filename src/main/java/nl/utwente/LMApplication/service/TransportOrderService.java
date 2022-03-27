package nl.utwente.LMApplication.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import nl.utwente.LMApplication.dto.TransportOrderDeliveryDateDto;
import nl.utwente.LMApplication.model.TransportOrder;

@Service
public class TransportOrderService {
    
    @Autowired RestTemplateBuilder restTemplateBuilder;

    public void updateTransportOrder(TransportOrder transportOrder){

        // define target url
        String url = "http://localhost:8081/salesOrder/" + transportOrder.getTransportOrderId();

        // create a variable to update transport order's delivery date
        Map<String, Date> transportOrderConfirmedDeliveryDate = new HashMap<>();
        transportOrderConfirmedDeliveryDate.put("confirmedDeliveryDate", transportOrder.getConfirmedDeliveryDate());

        // patch transport order's delivery date
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        restTemplate.patchForObject(url, transportOrderConfirmedDeliveryDate, TransportOrder.class);
    }

}
