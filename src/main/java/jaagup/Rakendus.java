package jaagup;

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
	private Company company;

	@RequestMapping("/algus")
	String tervitusfunktsioon() {
		return "Ahoi!";
	}
	@RequestMapping("/leia")

	String find(String name){
		if(name == null)
		{
			return "Nimi sisestamata";
		}
		Worker worker=company.findByName(name);
		return name+" tema vanus "+worker.age;
	}

	@RequestMapping("/count")
	public String coun(){
		return "Kokku firmas on " + company.count() + " töötajad";

	}
	@RequestMapping("/workers")
	public String workers(){
		String str = "Töötajate nimed on:</br>";

		for (Worker	worker : company.findAll()) {
			// fruit is an element of the `fruits` array.
			str = str + worker.name;
			str += "</br>";
		}


		return str;

	}


	public static void main(String[] args) {
		System.getProperties().put("server.port", 4235);
		SpringApplication.run(Rakendus.class, args);
	}
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot-1.jar