package nl.utwente.LMApplication.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
import nl.utwente.LMApplication.model.TransportOrder;
import nl.utwente.LMApplication.repository.TransportOrderRepository;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class MessageConsumer implements MessageListener {

    @Autowired
    TransportOrderRepository transportOrderRepository;

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String msg = ((TextMessage) message).getText();
                System.out.println("Message is received by MessageConsumer : " + msg);
                TransportOrder transportOrder = convertToTransportOrderObject(convertToTransportOrderHashmap(msg));
                // transportOrderController.updateTransportOrderFromTCA(transportOrder);

                // get the existing transport order based on the id
                TransportOrder existingTransportOrder = transportOrderRepository.findById(transportOrder.getTransportOrderId()).orElse(null);

                // update the transport company id
                existingTransportOrder.setTransportCompanyId(transportOrder.getTransportCompanyId());

                // update the truck id
                existingTransportOrder.setTruckId(transportOrder.getTruckId());

                // update the confirmed delivery date
                existingTransportOrder.setConfirmedDeliveryDate(transportOrder.getConfirmedDeliveryDate());

                // update the order status
                existingTransportOrder.setStatus(transportOrder.getStatus());
                transportOrderRepository.save(existingTransportOrder);

            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }

    public Map convertToTransportOrderHashmap(String msg) {
        msg = msg.substring(1, msg.length() - 1);
        String[] keyValuePairs = msg.split(",");
        Map<String, Object> map = new HashMap<>();

        for (String pair : keyValuePairs) {
            String[] entry = pair.split("=");
            map.put(entry[0].trim(), entry[1].trim());
        }
        return map;
    }

    // I need to find the transportOrder by Id and update it then call the method
    // sendConfirmedDelivery()
    public TransportOrder convertToTransportOrderObject(Map<String, Object> map) {

        TransportOrder transportOrder = transportOrderRepository
                .findById(Integer.parseInt(map.get("transportOrderId").toString())).orElse(null);

        transportOrder.setTransportCompanyId(Integer.parseInt(map.get("transportCompanyId").toString()));
        transportOrder.setTruckId(Integer.parseInt(map.get("truckId").toString()));
        transportOrder.setConfirmedDeliveryDate(transportOrder.getPickupDate());
        transportOrder.setStatus("Transportation Accepted");
        return transportOrder;
    }

}
