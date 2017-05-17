package vlasn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class Rakendus {

    @Autowired
    private InimesteHaldur inimesteHaldur;

	@RequestMapping("/algus")  
    String tervitusfunktsioon() {
        return "Tere";
    }
   
    @RequestMapping("/otsi")
    String leia(String isikukood){
       Inimene isik = inimesteHaldur.findOne(isikukood);
       if (isikukood == null) {
        return "Palun sisesta isikukood!";
       }
       if (isik == null) {
        return "Isik koodiga "+isikukood+" puudub andmebaasist!";
       }
       return "Isik koodiga: "+isikukood+" leiti!";
    }
    
    @RequestMapping("/uus")
    String lisa(String isikukood, double pikkus, double kaal, Integer vanus){
       Inimene isik = new Inimene();
       isik.isikukood = isikukood;
       isik.pikkus = pikkus;
       isik.kaal = kaal;
       isik.vanus = vanus;
       inimesteHaldur.save(isik);
       return "Lisasime isiku "+isikukood+"andmebaasi!";
    }

    public static void main(String[] args) {
		System.getProperties().put("server.port", 4000);
        SpringApplication.run(Rakendus.class, args);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot5-1.0.jar