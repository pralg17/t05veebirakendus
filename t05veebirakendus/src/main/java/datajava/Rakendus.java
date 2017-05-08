package datajava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Rakendus {
	@RequestMapping("/hinnakalkulaator")
	String hinnad(String hind, String kogus, String kliendikaart, String allahindlus){
		if(hind==null){return "andmed puuduvad";}
		int h=Integer.parseInt(hind);
		int k=Integer.parseInt(kogus);
		float maksta = h * k;
		if(allahindlus!=null){
			maksta=maksta/100*90;
			}
		
		return "Toode hind on " +hind+", kogus on  "+kogus+". Summa maksiseks on "+ maksta;
		
	}
    public static void main(String[] args) {
		System.getProperties().put("server.port", 5678);
        SpringApplication.run(Rakendus.class, args);
    }

}