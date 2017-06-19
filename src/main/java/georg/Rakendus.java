package georg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication

public class Rakendus {

    @RequestMapping("/astendatavarv")
    String astendatavarv(String astendatavarv){
        try{
            double Astendatav = Double.parseDouble(astendatavarv);
            return String.valueOf(Math.pow(Astendatav, 3));
        } catch (Exception e){
            return "Viga: "+e.getMessage();
        }
    }

    public static void main(String[] args){
        System.getProperties().put("server.port", 5454);
        SpringApplication.run(Rakendus.class, args);
    }
}


//http://localhost:4201/astendatavarv?astendatavarv=25
//ei saanud toole