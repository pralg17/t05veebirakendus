package Stivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Rakendus {
	@RequestMapping("/geomeetrilineKeskmine")
	String gk(String arv1, String arv2){
		if(arv1 == null){
			return "Andmed puuduvad";
		}
		int a1 = Integer.parseInt(arv1);
		int a2 = Integer.parseInt(arv2);
		return arv1 +" ja "+ arv2 +" geomeetriline keskmine on "+ Math.sqrt(a1*a2);
	}
	
	@RequestMapping("/geomeetrilineKeskmine3")
	String gk3(String arv1, String arv2, String arv3){
		if(arv1 == null){
			return "Andmed puuduvad";
		}
		int a1 = Integer.parseInt(arv1);
		int a2 = Integer.parseInt(arv2);
		int a3 = Integer.parseInt(arv3);
		return arv1 +", "+ arv2 +" ja "+ arv3 +" geomeetriline keskmine on "+ Math.pow(a1*a2*a3, (1.0/3));
	}
	
	
	
	
	
	@RequestMapping("/hinnaKalk")
	String hk(String arv1, String kaart){
		if(arv1 == null){
			return "Andmed puuduvad";
		}
		int kogus = Integer.parseInt(arv1);
		int kaartOlemas = Integer.parseInt(kaart);
		int hind;
		double kokku;
		if(kogus>5){
			hind = 2;
			kokku = kogus*hind;
		} else{
			hind = 3;
			kokku = kogus*hind;
		}
		if(kaartOlemas == 1){
			kokku = kokku*0.8;
		}
		return "Kliendi kaart: "+ kaartOlemas +"\nKogus on: "+ arv1 +"\nKokku on hind: "+ kokku;
	}

	
	
	
	
	
	

	@RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Ahoi!";
    }
 
	//lisage teine tervitusfunktsioon
	@RequestMapping("/algus2")
	String tervitusfunktsioon2() {
		return "Tere!!";
	}
	
	@RequestMapping("/tervita")
	String tervitusfunktsioon3(String eesnimi){
		return "Tere, "+ eesnimi;
	}
	
    public static void main(String[] args) {
		//System.getProperties().put("server.port", 4444);
        SpringApplication.run(Rakendus.class, args);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar