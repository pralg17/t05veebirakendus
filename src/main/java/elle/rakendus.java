package elle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
@RestController
public class rakendus{
	@Autowired
	private laohaldur haldur;
	//Otsing
	@RequestMapping("/find")
 	String find(String jook){
 		if(jook == null){
 			return "Tyhi sisestus";
 		}
 		tooted toode = haldur.findOne(jook);
 		if(toode == null){
 			return "Selline jook puudub.";
 		}
 		return "Jook  " + jook + "  toote nimi  " + toode.nimi + "  kogus  " + toode.kogus;
 	}
	//Total
 	@RequestMapping("/total")
 	public String total(){
 		return "Andmebaasis on " + haldur.count() + " tulemust";
 	}
	//Uue toote lisamine
 	@RequestMapping("/addNewItem")
 	public String new_item(String jook, String nimi, double kogus){
 		if(jook == null || nimi == null || kogus == 0){
 			return "Lisa andmed";
 			}
 			tooted n_tooted = new tooted();
 			n_tooted.jook = jook;
 			n_tooted.nimi = nimi;
 			n_tooted.kogus = kogus;
 			haldur.save(n_tooted);
 			return "Lisatud on toode " + jook + "mille nimetus on "+ nimi +"ja kogus "+kogus;
 	}
	public static void main(String[] args) {
		System.getProperties().put("server.port", 4022);
		System.getProperties().put("spring.datasource.url",
		   "jdbc:mysql://localhost/if16_elleivan");
		System.getProperties().put("spring.datasource.username", "if16");
		System.getProperties().put("spring.datasource.password", "ifikad16");
		SpringApplication.run(rakendus.class);
	}
}


//scl enable rh-maven33 bash
//mvn package
//java -jar target/app-1.jar 
