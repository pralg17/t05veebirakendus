package riff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class App {
    @Autowired
    
    private PlanetData planetData;    
    
    @RequestMapping("/find")
	String find(String name){
        if(name == null) {
            return "Planeet valimata";
        }
        Planet planet = planetData.findByName(name);
        return name+":Kaugus päikesest - "+planet.fromSun+", Liikumiskiirus - "+planet.speed;
	}

    public static void main(String[] args) {
		System.getProperties().put("server.port", 4200);
        SpringApplication.run(App.class, args);
    }
}
