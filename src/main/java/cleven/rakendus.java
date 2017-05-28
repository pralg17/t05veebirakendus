package cleven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class rakendus {
	@Autowired
	@RequestMapping("/tervita")
    public String tervitusfunktsioon() {
        return "tervitus";
    }

	@RequestMapping("/hind")
	String hk(String hind, String kogus, String kaart){
		double dhind = Double.parseDouble(hind);
		int ikogus = Integer.parseInt(kogus);
		boolean bkaart = Boolean.parseBoolean(kaart);
		
		double hind_kokku;
		double soodus = 0.15;

		if(bkaart){
			hind_kokku=(dhind*ikogus)-(dhind*ikogus*soodus);
			return "Hind on kokku: "+ hind_kokku +"\nTe saastsite: "+ dhind*ikogus*soodus +" eurot.";
		}else{
			hind_kokku = dhind*ikogus;
			return "Hind on kokku: "+ hind_kokku +"\nTe saastsite: 0 eurot.";
		}
		
	}
	
 
    public static void main(String[] args) {
		System.getProperties().put("server.port", 4288);
        SpringApplication.run(rakendus.class, args);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar