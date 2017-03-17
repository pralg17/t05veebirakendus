package karin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Rakendus {
	@Autowired
	private ViljaHaldur haldur;
	
	@RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Ahoi!";
    }
	
	//CREATE          haldur.save
	@RequestMapping("/uus")
	String lisa(String vnimi, float vhind, float vkogus){
	   Vili v = new Vili();
	   v.nimi = vnimi;
	   v.hind = vhind;
	   v.kogus = vkogus;
	   haldur.save(v);
	   return "Lattu lisati "+ vnimi;
	}
	

	
	//READ          haldur.findOne
	@RequestMapping("/leia")                       //leia?vnimi=porgand
	public String otsi(String vnimi){             
		if(vnimi==null){                          //kas aadressireal on nimi sisestatud
			return "Vili määramata";
		}
		
		Vili v = haldur.findOne(vnimi);      
		if(v == null){                             //sellist nime ei leitud
			return "Laos pole";
		}
		return vnimi + " laoseis : " + v.kogus + "kilo, hind: " + v.hind;
	}
	
	//UPDATE  (muuda midagi)    haldur.findOne
	@RequestMapping("/muuda")                             //muuda?vnimi=porgand&vhind=0.38
	public String muuda(String vnimi, String vhind){            
		if(vnimi == null || vhind == null){
			return "Vili määramata v6i uus hind m22ramata";
		}
		Vili v = haldur.findOne(vnimi);     
		if(v == null){
			return "Laost ei leitud: " + vnimi;
		}
        v.hind = Float.parseFloat(vhind);   //sest andmebaasis on float
        haldur.save(v);	
        return "Uus hind on: " + vhind;		
	}
	
	//UPDATE (lisa midagi)             haldur.findOne
	@RequestMapping("/lisa")                           //lisa?vnimi=paprika&vkogus=4
	public String lisa(String vnimi, String vkogus){
		if(vnimi == null){
			return "Vili määramata";
		}
		Vili v = haldur.findOne(vnimi);     
		if(v == null){
			return "Laost ei leitud: " + vnimi;
		}
        v.kogus += Float.parseFloat(vkogus);   //lisa juurde
        haldur.save(v);	
        return "Uus kogus on: " + v.kogus;		
	}
	
	//DELETE            haldur.delete
	@RequestMapping("/kustuta")                      //kustuta?nimi=kartul
	public String kustuta(String nimi){
		if(nimi == null){
			return "Vili määramata";
		}
		Vili v = haldur.findOne(nimi);
		if(v == null){                     
			return "Sellist juurvilja pole";
		}
		haldur.delete(v);
		return nimi + " on andmebaasist kustutatud";
	}
		
	public static void main(String[] args) {
		System.getProperties().put("server.port", 2412);
		SpringApplication.run(Rakendus.class);
	}
}

//scl enable rh-maven33 bash
//mvn package && java -jar target/sql-0.0.1-SNAPSHOT.jar

