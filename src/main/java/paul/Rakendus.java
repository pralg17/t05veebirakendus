package paul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@SpringBootApplication
public class Rakendus {
	@Autowired
	private Toiduaine toiduaine;
	
	
	@RequestMapping("/leia")
	String leia(String name){
		if(name == null)
		{
			return "Toiduainet pole";
		}
		Toiduaine toiduaine=pood.findByName(name);
		return name+" tema hind on "+toiduaine.price;
	}

	public static void main(String[] args) {
		System.getProperties().put("server.port", 4227);
		SpringApplication.run(Rakendus.class, args);
	}
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot-1.jar