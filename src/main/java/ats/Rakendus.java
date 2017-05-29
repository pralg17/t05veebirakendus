package ats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@SpringBootApplication
public class Rakendus {
	@RequestMapping("/isikuleht")
 	public String isik(String eesnimi, String perekonnanimi, String isikukood){
 	eesnimi = "Ats";
 	perekonnanimi = "Klemmer";
 	isikukood = "39511020244";
 		   return "Tere, "+eesnimi+ " " + perekonnanimi + ", Teie isikukood on " + isikukood + "!";
 	}

 	@RequestMapping("/isikukood")
 	public String kood(String isikukood){
 		if (isikukood.length()==11){
 			return isikukood;
 		} else {
 			return "Halb";
 		}
 	}
    public static void main(String[] args) {
		System.getProperties().put("server.port", 4783);
        SpringApplication.run(Rakendus.class, args);
    }
}

  //scl enable rh-maven33 bash
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar


//Running ats.EsimeneTest
//Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.007 sec - in ats.EsimeneTest

