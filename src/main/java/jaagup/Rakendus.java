package jaagup;

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
	private Store store;
	
	@RequestMapping("/algus")
	String tervitusfunktsioon(){
		return"Ahoi karvajalg!";
	}
	
	@RequestMapping("/leia")
	String find(String name){
		if(name==null){
			return"Nimi sisestamata!";
		}
		Plant plant=store.findByName(name);
		return name+" hind on "+plant.hind;
	}
	
	
	@RequestMapping("/count")
	public String coun(){
		return "Kokku on poes  "+ store.count() + "erinevat taime.";
	}
	

	
	public static void main(String[] args){
		System.getProperties().put("server.port",4234);
		SpringApplication.run(Rakendus.class,args);
	}
}

//scl enable rh-maven33 bash
 //mvn package
 //java -jar target/boot-1.jar