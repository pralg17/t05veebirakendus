package rihard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Rakendus {
	@RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Tervitus!";
    }
	
	@RequestMapping("/tervita")
	String tervitusfunktsioon3(String eesnimi){
		return "Tere, "+eesnimi;
	}
	
    //Lisage teine tervitusfunktsioon
	@RequestMapping("/algus2")
    String tervitusfunktsioon2() {
        return "Tere taas!";
    }
	
	@RequestMapping("/tere")
	String fullname (String eesnimi, String perekonnanimi){
		if (eesnimi == null) {return "eesnimi puudub";}
		if (perekonnanimi == null) {return "perekonnanimi puudub";}
		return "Tere, "+eesnimi.substring(0,1)+". "+perekonnanimi;
	}
	
	@RequestMapping("/geokeskmine")
    String geokeskmine(String arv1, String arv2) {
		try{
        double a1=Double.parseDouble(arv1);
		double a2=Double.parseDouble(arv2);
		return String.valueOf(Math.sqrt(a1*a2));
		}catch(Exception e){
			return "Viga: "+e.getMessage();
		}
	}
	
	
    public static void main(String[] args) {
		System.getProperties().put("server.port", 4213);
        SpringApplication.run(Rakendus.class, args);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar