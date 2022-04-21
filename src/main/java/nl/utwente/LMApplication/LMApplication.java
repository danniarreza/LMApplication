package nl.utwente.LMApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nl.utwente.LMApplication.publisher.MessageProducer;

@SpringBootApplication(scanBasePackages = "nl.utwente.LMApplication")
public class LMApplication implements CommandLineRunner{

	@Autowired
	private MessageProducer messageProducer;

	public static void main(String[] args) {
		SpringApplication.run(LMApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		messageProducer.sendMessage("Send this message to default destination.");

	}
}
