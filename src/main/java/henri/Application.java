package henri;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController



public class Application{
	
	@Autowired
	private ManageTable manager;
	
	@RequestMapping("/create")
	String create(String apartment, String county, Integer price){
		manager.save(new Apartments(apartment, county, price));
		return "korter "+ county +" lisatud";
	}
	
	@RequestMapping("/search")
    String Search(String county){
        if(county.isEmpty()){return "no info";}
        List<Apartments> apartments=manager.findBycounty(county);
        if(apartments.isEmpty()){return county+" not found";}
		StringBuffer sb = new StringBuffer();
		for(Apartments apartment: apartments){
			sb.append("<p>");
			sb.append("Maakonnas "+ county +" on olemas korter hinnaga "+apartment.price.toString());
			sb.append("</p>");
		}
		return sb.toString();

	}
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
	
}



