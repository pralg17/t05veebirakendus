package kodune;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Rakendus {
	@Autowired
	private RiigiHaldur haldur;
	
	
	@RequestMapping("/kokku")
	public String kokku1(){
		return "Andmebaasist leiti "+haldur.count()+" riigi andmed.";
	}
	
	
	@RequestMapping("/v6rdlus")
	public String v6rdlus1(String riik1, String riik2){
		if (riik1==null || riik2==null){
			return "V6rdlemiseks on vaja kahte riiki!";
		}
		Riigid r1 = haldur.findOne(riik1);
		Riigid r2 = haldur.findOne(riik2);
		if(r1 == null || r2 == null){
			if(r1 == null){
				return "Andmebaasist ei leitud esimest sisestatud riiki.";
			}
				return "Andmebaasist ei leitud teist sisestatud riiki.";
		}

		int tihedus1 = r1.rahvaarv/r1.pindala;
		int tihedus2 = r2.rahvaarv/r2.pindala;
 		if(tihedus1 >= tihedus2){
			return riik1+" rahvastikutihedus(~"+tihedus1+" inimest ruutkilomeetri kohta) on suurem kui "+riik2+" rahvastikutihedus(~"+tihedus2+" inimest ruutkilomeetri kohta).";
		}
			return riik2+" rahvastikutihedus(~"+tihedus2+" inimest ruutkilomeetri kohta) on suurem kui "+riik1+" rahvastikutihedus(~"+tihedus1+" inimest ruutkilomeetri kohta).";

	}
	
	

	public static void main(String[] args) {
		System.getProperties().put("server.port", 4208);
		System.getProperties().put("spring.datasource.url", 
		   "jdbc:mysql://localhost:3306/if16_eric_2?useSSL=false");
		System.getProperties().put("spring.datasource.username", "if16");
		System.getProperties().put("spring.datasource.password", "ifikad16");
		SpringApplication.run(Rakendus.class);
	}

} 
