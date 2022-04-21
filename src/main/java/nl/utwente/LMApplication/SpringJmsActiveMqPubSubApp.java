package nl.utwente.LMApplication;

import nl.utwente.LMApplication.publisher.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication(scanBasePackages = "nl.utwente.LMApplication")
public class SpringJmsActiveMqPubSubApp implements CommandLineRunner {

    @Autowired
    private MessagePublisher messagePublisher;


    @Override
    public void run(String... args) throws Exception {
//        TransportOrder transportOrder= new TransportOrder();
//        transportOrder.setTransportOrderId(1);
//        transportOrder.setBranchId(2);

        Map<String, Object> transportOrder = new HashMap<>();

        transportOrder.put("transportOrderId", "3");
        transportOrder.put("branchId", "2");

        String message = transportOrder.toString();
        messagePublisher.sendMessage(message);
    }

}
