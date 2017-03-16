package rasmus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Rakendus {
	@Autowired
	private HindadeHaldur haldur;
	
	@RequestMapping("/hinnasuurendamine")
	public String suurendamine(String ese, float summa){
		if(ese==null){return "Ese määramata";}
		Hinnad k=haldur.findOne(ese);
		if(k==null){
			return ese+" puudub";
		}
        k.hind=k.hind+summa;
        haldur.save(k);	
        return uuring1(ese);		
	}
	
	@RequestMapping("/hinnavahendamine")
	public String vahendamine(String ese, float summa){
		if(ese==null){return "Ese määramata";}
		Hinnad k=haldur.findOne(ese);
		if(k==null){
			return ese+" puudub";
		}
        k.hind=k.hind-summa;
        haldur.save(k);	
        return uuring1(ese);		
	}
	
	@RequestMapping("/summauuring")
	public String uuring1(String ese){
		if(ese==null){return "Ese määramata";}
		Hinnad k=haldur.findOne(ese);
		if(k==null){
			return ese+" puudub";
		}
		return ese+" maksab "+k.hind;
	}

	public static void main(String[] args) {
		System.getProperties().put("server.port", 6537);
		System.getProperties().put("spring.datasource.url", 
		   "jdbc:mysql://localhost/if16_Aaviste_semester");
		System.getProperties().put("spring.datasource.username", "if16");
		System.getProperties().put("spring.datasource.password", "ifikad16");
		SpringApplication.run(Rakendus.class);
	}
}
//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar