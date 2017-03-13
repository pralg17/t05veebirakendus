package thetloffline;

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
        return "Ahoi!";
    }
   
    @RequestMapping("/leia")
    String leia(String isikukood){
       Inimene isik = inimesteHaldur.findOne(isikukood);
       if (isikukood == null) {
        return "isikukood sisestamata!";
       }
       if (isik == null) {
        return "isik " + isikukood + " puudub baasist";
       }
       return "isik isikukoodiga: " + isikukood + " on leitud!";
    }
    
    @RequestMapping("/lisa")
    String lisa(String isikukood, double pikkus, double kaal){
       Inimene isik = new Inimene();
       isik.isikukood = isikukood;
       isik.pikkus = pikkus;
       isik.kaal = kaal;
       inimesteHaldur.save(isik);
       return "Isik isikukoodiga: " + isikukood + " on lisatud andmebaasi!";
    }

    public static void main(String[] args) {
		System.getProperties().put("server.port", 4265);
        SpringApplication.run(Rakendus.class, args);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot5-1.0.jar