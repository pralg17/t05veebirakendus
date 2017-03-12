package karlerik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication

public class Rakendus {
	
	@Autowired
	private KitarriHaldur haldur;
	
	
	@RequestMapping("/leia")
	String leia(Integer id) {
		Kitarrid kitarr = haldur.findOne(id);
		return kitarr.brand + " " + kitarr.model;
	}
	
	@RequestMapping("/loetelu")
	public String loetelu() {
		StringBuffer sb = new StringBuffer();
		for(Kitarrid kitarr: haldur.findAll()) {
			sb.append(kitarr);
		}
		String thead = "<tr><th>ID</th><th>Tootja</th><th>Mudel</th><th>Hind</th><th>Keelte arv</th><th>Tüüp</th></tr>";
		return thead + sb.toString();
	}
	
	@RequestMapping("/lisa")
	String lisa(String brand, String model, Integer price, Integer strings, String type) {
		Kitarrid kitarr = new Kitarrid();
		kitarr.brand = brand;
		kitarr.model = model;
		kitarr.price = price;
		kitarr.strings = strings;
		kitarr.type = type;
		
		haldur.save(kitarr);
		return "Lisatud " + brand + " " + model;
	}
	
	@RequestMapping("/kustuta")
	public String kustuta(Integer id, String brand, String model) {
		Kitarrid kitarr = haldur.findOne(id);
		haldur.delete(kitarr);
		return kitarr.brand + " " + kitarr.model + " on kustutatud";
	}
	
	
	public static void main(String[] args) {
		System.getProperties().put("server.port", 4221);
		SpringApplication.run(Rakendus.class, args);
	}
}