package rauntege;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication

public class Rakendus {

    @RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Ahoi!";
    }
    
    @RequestMapping("/eurocalc")
    String eurocalc(String kroon){
        try{
            double eek = Double.parseDouble(kroon);
            return String.valueOf(eek * 0.064);
        } catch(Exception e){
            return "ERROR: "+e.getMessage();
        }
    }

    public static void main(String[] args) {
		System.getProperties().put("server.port", 2171);
        SpringApplication.run(Rakendus.class, args);
    }
}


//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot-1.jar
//http://localhost:2171/eurocalc?kroon=15
