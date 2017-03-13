package oscar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication

public class Rakendus{
	
	@RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Ahoi!";
    }
	
	@RequestMapping("/geomeetriline_keskmine")
	String geomkesk(String arv1, String arv2){
	  try{
		double a1=Double.parseDouble(arv1);
		double a2=Double.parseDouble(arv2);
		return String.valueOf(Math.sqrt(a1*a2));
	  } catch(Exception e){
		 return "Viga: "+e.getMessage();
	  }
	}

	@RequestMapping("/pudrucal")
	String pudrucal(String banaan, String mesi, String helbed, String piim){
	  try{
		double a1=Double.parseDouble(banaan);
		double a2=Double.parseDouble(mesi);
		double a3=Double.parseDouble(helbed);
		double a4=Double.parseDouble(piim);
		return String.valueOf((a1*0.93)+(a2*3.3)+(a3*3.5)+(a4*0.52));
	  } catch(Exception e){
		 return "Viga: "+e.getMessage();
	  }
	}
	 
	 public static void main(String[] args) {
		System.getProperties().put("server.port", 4281);
        SpringApplication.run(Rakendus.class, args);
    }
}
//scl enable rh-maven33 bash
//mvn package
//java -jar target/boothtml-1.0-SNAPSHOT.jar

//localhost:4281/geomeetriline_keskmine?arv1=5&arv2=7
//localhost:4281/pudrucal?banaan=5&mesi=7&helbed=7&piim=7