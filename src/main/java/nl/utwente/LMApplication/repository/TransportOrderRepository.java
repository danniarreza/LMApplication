package nl.utwente.LMApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.utwente.LMApplication.model.TransportOrder;

// @Service
public interface TransportOrderRepository extends JpaRepository<TransportOrder, Integer> {
    // private static final List<TransportOrder> transportOrderList = new ArrayList<>();
    // private static int idCounter = 1;

    // public TransportOrder createTransportOrder(TransportOrder transportOrder){
    //     transportOrder.setTransportOrderId(idCounter++);
    //     transportOrderList.add(transportOrder);
    //     return transportOrder;
    // }

    // public TransportOrder updateTransportOrder(TransportOrder transportOrder){

    //     return transportOrder;
    // }

    // public TransportOrder getTransportOrder(int id){

    //     for (TransportOrder transportOrder : transportOrderList) {
    //         if (transportOrder.getTransportOrderId() == id){
    //             return transportOrder;
    //         }
    //     }

    //     return null;
    // }

    // public int deleteTransportOrder(int id){
    //     transportOrderList.remove(id);
    //     return id;
    // }

    // public List<TransportOrder> getTransportOrderAll(){
    //     return transportOrderList;
    // }


}
