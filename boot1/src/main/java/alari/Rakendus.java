package alari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Rakendus{
	
	@Autowired
	
	private RattaHaldur haldur;
	
	@RequestMapping("/lisa")
	public String lisa(String brand, String model, int price) {
		Rattad ratas = new Rattad();
		ratas.brand = brand;
		ratas.model = model;
		ratas.price = price;
		haldur.save(ratas);
		return "Lisatud " + brand + " " + model + " hinnaga " + price+" euri ";
	}
	
	@RequestMapping("/leia")
	public String leia(String bikeName) {
		if(bikeName==null){
			return "Sellist ratast ei ole";
		}
		
		Rattad model = haldur.findOne(bikeName);
		if(bikeName==null){
			return "Sellist ratast ei ole";
		}
		
		return "Ratas "+model.brand+" "+bikeName+" on olemas ja maksab "+model.price+"euri";
		
	}
	
	
	

	
	
	
	
	public static void main(String[] args) {
		System.getProperties().put("server.port", 5555);
		System.getProperties().put("spring.datasource.url", "jdbc:mysql://localhost:3306/if16_ALARI?useSSl=false");
		System.getProperties().put("spring.datasource.username", "if16");
 		System.getProperties().put("spring.datasource.password", "ifikad16");
        SpringApplication.run(Rakendus.class);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot1-1.jar