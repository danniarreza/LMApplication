package nl.utwente.LMApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import nl.utwente.LMApplication.dto.TransportOrderUpdateDto;
import nl.utwente.LMApplication.model.TransportOrder;

@Service
public class TransportOrderService {
    
    @Autowired RestTemplateBuilder restTemplateBuilder;

    public void updateTransportOrder(TransportOrder transportOrder){

        // define target url
        // String url = "http://localhost:8081/salesOrder/" + transportOrder.getSalesOrderId();
        String url = "http://sma:8081/salesOrder/" + transportOrder.getSalesOrderId();

        // create a variable to update transport order's delivery date

        TransportOrderUpdateDto transportOrderUpdateDto = new TransportOrderUpdateDto();

        transportOrderUpdateDto.setConfirmedDeliveryDate(transportOrder.getConfirmedDeliveryDate());
        transportOrderUpdateDto.setPickupDate(transportOrder.getPickupDate());
        transportOrderUpdateDto.setProposedDeliveryDate(transportOrder.getProposedDeliveryDate());
        transportOrderUpdateDto.setStatus(transportOrder.getStatus());
        transportOrderUpdateDto.setSalesOrderId(transportOrder.getSalesOrderId());

        // patch transport order's delivery date
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        restTemplate.patchForObject(url, transportOrderUpdateDto, TransportOrder.class);
    }

}
