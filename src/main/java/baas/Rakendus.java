package baas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Rakendus {
	@Autowired
	private KasutajateHaldur haldur;
	
	@RequestMapping("/lisamine")
	public String lisamine(String knimi, float kogus){
		if(knimi==null){return "Kasutaja maaramata";}
		Kasutaja k=haldur.findOne(knimi);
		if(k==null){
			return knimi + "puudub";
		}
		k.saldo=k.saldo+kogus;
		haldur.save(k);
		return uuring1(knimi);
	}
	
	@RequestMapping("/kustutamine")
	public String kustutamine(String knimi){
		if(knimi==null){return "Kasutaja maaramata";}
		Kasutaja k=haldur.findOne(knimi);
		if(k!=null){
			haldur.delete(k);
			return knimi + " kustutatud";
		}
		return uuring1(knimi);
	}
	
	@RequestMapping("/rahauuring")
	public String uuring1(String knimi){
		if(knimi==null){return "Kasutaja maaramata";}
		Kasutaja k=haldur.findOne(knimi);
		if(k==null){
			return knimi + "puudub";
		} 
		return knimi+" kontol "+k.saldo;
	}
	 
	@RequestMapping("/tervitusleht1")
	public String tervitus1(String eesnimi){
		return "Tere, "+eesnimi+"!";
	}
	public static void main(String[] args) {
		System.getProperties().put("server.port", 4210);
		System.getProperties().put("spring.datasource.url", 
		   "jdbc:mysql://localhost:3306/if16_anu");
		System.getProperties().put("spring.datasource.username", "if16");
		System.getProperties().put("spring.datasource.password", "ifikad16");
		SpringApplication.run(Rakendus.class);
	}

}