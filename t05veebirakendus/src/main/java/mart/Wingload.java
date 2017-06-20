package mart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Wingload {

	@RequestMapping("/algus")  
    String tervitusfunktsioon() {
         return "Tere";
     }
	
    public static void main(String[] args) {
		System.getProperties().put("server.port", 1234);
        SpringApplication.run(Wingload.class, args);
		Inimene inimene1=new Inimene(70.0, 150.0);
		Inimene inimene2=new Inimene(80.0, 200.0);
		System.out.println("Kui lbs oleks kg siis mu kaal oleks suur:"+inimene1.lbs());	
		System.out.println("Wingload1 on:"+inimene1.lbs()/inimene1.ruutjalad);
		System.out.println("Wingload2 on:"+inimene1.lbs()/inimene2.ruutjalad);
    }
}	

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot1-1.0-SNAPSHOT.jar