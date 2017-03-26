package marko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Rakendus{


    public static void main(String[] args){
        System.getProperties().put("server.port", 4245);
        SpringApplication.run(Rakendus.class, args);
    }
}