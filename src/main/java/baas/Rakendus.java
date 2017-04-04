package baas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
@RestController
public class Rakendus{
	@Autowired
	private varjupaigahaldur haldur;
	//Otsing
	@RequestMapping("/find")
 	String find(String t9ug){
 		if(t9ug == null){
 			return "Tyhi sisestus";
 		}
 		koerad koer = haldur.findOne(t9ug);
 		if(koer == null){
 			return "Selline toug puudub.";
 		}
 		return "Toug  " + t9ug + "  koerakese nimi  " + koer.nimi + "  vanus  " + koer.vanus;
 	}
	//Total 
 	@RequestMapping("/total")
 	public String total(){
 		return "Andmebaasis on " + haldur.count() + " tulemust";
 	}
	//Uue koera lisamine	
 	@RequestMapping("/addNewDog")
 	public String new_dog(String t9ug, String nimi, int vanus){
 		if(t9ug == null || nimi == null || vanus == 0){
 			return "Lisa andmed";
 			}	
 			koerad n_koerad = new koerad();
 			n_koerad.t9ug = t9ug;
 			n_koerad.nimi = nimi;
 			n_koerad.vanus = vanus;
 			haldur.save(n_koerad);
 			return "Lisatud on koer " + t9ug + "kelle nimi:"+ nimi +"ja vanus"+vanus;
 	}
	public static void main(String[] args) {
		System.getProperties().put("server.port", 5403);
		System.getProperties().put("spring.datasource.url", 
		   "jdbc:mysql://localhost/if16_krisroos_3");
		System.getProperties().put("spring.datasource.username", "if16");
		System.getProperties().put("spring.datasource.password", "ifikad16");
		SpringApplication.run(Rakendus.class);
	}
}