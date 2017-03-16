package taankomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Rakendus {

	@RequestMapping("hinnakalkulaator")
	String hk(String hind, String kogus, String klient){
		if(kogus==""){return "Ostukorv on tühi!";}
		double a1=Double.parseDouble(hind);
		int a2=Integer.parseInt(kogus);

		if(0 >= a2){return "Ostukorv on tühi!";}
		if(klient!=null && 2 < a2){
			return "Ostes rohkem kui 2 eset lisandub soodustus -10%. Kliendina (lisandub soodustus -10%) on summa: " +((a1*a2)-((a1*a2)*0.2))+" eurot.";
		}
		else if(2 < a2){
			return "Kliendikaarti ei ole! Ostes rohkem kui 2 eset lisandub soodustus -10%. Summa: "+((a1*a2)-((a1*a2)*0.1))+" eurot.";
		} else if(klient!=null){
			return "Kliendina lisandub soodustus -10%. Summa: " +((a1*a2)-((a1*a2)*0.1))+ " eurot.";
		} else{
			return "Kliendikaarti ei ole! Summa: "+(a1*a2)+" eurot.";
		}
	}

    public static void main(String[] args) {
		//System.getProperties().put("server.port", 4200);
        SpringApplication.run(Rakendus.class, args);
    }
}
