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
    private LoenguHaldur loenguHaldur;
	
	@RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Ahoi!";
    }
    @RequestMapping("/leia")
	String leia(String ruhm){
		if(ruhm==null){return "ruhm sisestamata";}
		Loeng loeng= loenguHaldur.findByRuhm(ruhm);
		
		return "rühm: "+loeng.ruhm+"\n algus: "+loeng.algus+"\n lõpp: "+loeng.lopp+"\n paev: "+loeng.paev;
	}
	//
	
    @RequestMapping("/lisa")
	String lisa(String ruhm,String algus,String lopp,String paev){
	   Loeng loeng=new Loeng();
	   loeng.ruhm=ruhm;
	   loeng.algus=algus;
	   loeng.lopp=lopp;
	   loeng.paev=paev;
	   if(ruhm==null || algus==null || lopp==null || paev==null){return "midagi on url'is valesti";}
	   loenguHaldur.save(loeng);
	   return "Lisatud loeng rühmale "+ruhm;
	}
	
    public static void main(String[] args) {
		System.getProperties().put("server.port", 5554);
        SpringApplication.run(Rakendus.class, args);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot-1.jars