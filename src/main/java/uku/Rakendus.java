package uku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class Rakendus {
    @Autowired
    private LugejateHaldur lugejaHaldur;
	
	@RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Ahoi!";
    }
    @RequestMapping("/leia")
	String leia(String email){
		if(email==null){return "aaress sisestamata";}
	    Lugeja isik=lugejaHaldur.findByEmail(email);
		if(isik==null){return email+" puudub baaisist";}
		return email+" laenutusi "+isik.laenutusi;
	}
	
    @RequestMapping("/lisa")
	String lisa(String email){
	   Lugeja isik=new Lugeja();
	   isik.email=email;
	   isik.laenutusi=1;
	   lugejaHaldur.save(isik);
	   return "Lisatud "+email;
	}
	
    public static void main(String[] args) {
		System.getProperties().put("server.port", 42999);
        SpringApplication.run(Rakendus.class, args);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot-1.jars