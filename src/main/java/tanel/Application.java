package tanel;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

//funktsiooni nimed ja muutujad on väikese algustähega
//klassinimed camelcase

public class Application{
	
	@Autowired
	private ManageTable manager;
	
	@RequestMapping("/create")
	String create(String kauplus, String tooteNimi, Integer hind){
		manager.save(new Tooted(kauplus, tooteNimi, hind));
		return "Toode "+ tooteNimi +" lisatud";
	}
	
	@RequestMapping("/search")
    String Search(String tooteNimi){
        if(tooteNimi.isEmpty()){return "no info";}
        List<Tooted> tooted=manager.findBytooteNimi(tooteNimi);
        if(tooted.isEmpty()){return tooteNimi+" not found";}
		StringBuffer sb = new StringBuffer();
		for(Tooted toode: tooted){
			sb.append("<p>");
			sb.append("Toode " + tooteNimi + " on kaupluses nimega " + toode.kauplus + " ja see maksab: "+ toode.hind.toString());
			sb.append("</p>");
		}
		return sb.toString();

	}
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
	
}



