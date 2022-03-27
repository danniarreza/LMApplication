package nl.utwente.LMApplication.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import nl.utwente.LMApplication.model.TransportOrder;

@Service
public class TransportOrderRepository {
    private static final List<TransportOrder> transportOrderList = new ArrayList<>();
    private static int idCounter = 1;

    public TransportOrder createTransportOrder(TransportOrder transportOrder){
        transportOrder.setTransportOrderId(idCounter++);
        transportOrderList.add(transportOrder);
        return transportOrder;
    }

    public TransportOrder updateTransportOrder(TransportOrder transportOrder){

        // get the existing transport order based on the id
        TransportOrder existingTransportOrder = getTransportOrder(transportOrder.getTransportOrderId());

        // update the confirmed delivery date
        existingTransportOrder.setConfirmedDeliveryDate(transportOrder.getConfirmedDeliveryDate());

        // get the index of the existing transport order
        int index = transportOrderList.indexOf(existingTransportOrder);

        // update the list with the updated transport order
        transportOrderList.set(index, existingTransportOrder);
        return existingTransportOrder;
    }

    public TransportOrder getTransportOrder(int id){

        for (TransportOrder transportOrder : transportOrderList) {
            if (transportOrder.getTransportOrderId() == id){
                return transportOrder;
            }
        }

        return null;
    }

    public int deleteTransportOrder(int id){
        transportOrderList.remove(id);
        return id;
    }

    public List<TransportOrder> getTransportOrderAll(){
        return transportOrderList;
    }


}
