package edgar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@SpringBootApplication
public class Rakendus{
	@Autowired
	public Customers customers;
	public customerManager customerManager;
	
	@RequestMapping("/find")
	String find(String name){
		if(name == null){
			return "Such name is not recorded in database, try again.";
		}
		Customers customer = customerManager.findByName(name);
		if(customer == null){
			return "The customer you requested does not exist";
		}
		return "Name:" + name + "</br>Surname: " + customer.surname + "</br>E-mail: " + customer.email + "</br>Number:" + customer.number;
	}
	
	@RequestMapping("/total")
	public String total(){
		return "Total quantity of entries: " + customerManager.count();
	}
	
	@RequestMapping("/showAll")
	public String all(){
		
		String show_data = "";
		int index = 0;
		
		for(Customers customer : customerManager.findAll()){
			index += 1;
			show_data = show_data + index + "  " + "    " + customer.name + "    " + customer.surname + "    " + customer.email + "    " + customer;
			show_data += "</br>";
		}
		
		return show_data;
		
	}
	
	@RequestMapping("/newCustomer")
	public String new_customer(String name, String surname, String email, int number){
		if(name == null || surname == null || email == null || number == 0){
			return "All fields must filled in";
		}
		Customers n_customer = new Customers();
		n_customer.name = name;
		n_customer.surname = surname;
		n_customer.email = email;
		n_customer.number = number;
		customerManager.save(n_customer);
		return "New customer is registred: " + name + surname;
	}
	
	public static void main(String[] args){
		System.getProperties().put("server.port", 4221);
		SpringApplication.run(Rakendus.class);
	}
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar
//java -jar target/boot3-1.0-SNAPSHOT.jar
//java -jar target/boot3-1.0-SNAPSHOT.jar
//java -jar target/boot3-1.0-SNAPSHOT.jar