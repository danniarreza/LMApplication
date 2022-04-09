package nl.utwente.LMApplication.init;

import nl.utwente.LMApplication.model.TransportOrder;
import nl.utwente.LMApplication.repository.TransportOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Component
public class InitTransportOrder {

    @Autowired
    TransportOrderRepository transportOrderRepository;

    @Autowired
    SharedMethod sharedMethod;

    // @PostConstruct
    // public void init(){

    //     Date currentDate = new Date();

    //     Date pickupDate = sharedMethod.addDate(currentDate, 5);

    //     TransportOrder transportOrder = new TransportOrder(1, 1, new ArrayList<>(), 14, 0, 0, 1600, currentDate, pickupDate, currentDate, null, "Transport Requested");
    //     transportOrderRepository.save(transportOrder);
    // }

}
