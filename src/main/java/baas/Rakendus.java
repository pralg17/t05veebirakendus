package t05veebirakendus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController

public class Rakendus {
	
	@Autowired
	private FilmideHaldur haldur;
	
	//Arvutab Pythagorasega täisnurkse kolmnurga kahe kaateti abil välja hüpotenuusi
	//Arve saab sisestada aadressi realt 
	//Näide: http://localhost:5555/pythagorase?arv1=5&arv2=5
	//Vastus: Hüpotenuusi pikkuseks on 7.0710678118654755
	@RequestMapping("/pythagorase")
	public String pythagorase(String arv1, String arv2){
		try{		
			double a1=Double.parseDouble(arv1);
			double a2=Double.parseDouble(arv2);
			return "Hüpotenuusi pikkuseks on " + String.valueOf(Math.sqrt(Math.pow(a1,2)+Math.pow(a2,2)));
		} catch(Exception ex){
			return ex.getMessage();
		}
	}
	
	//loen kokku, mitu filmi andmebaasis on
	@RequestMapping("/kokkulugemine")
	public String lugemine1(){	
		return "Andmebaasis on "+haldur.count() + " filmi";
	}
	
	//otsin andmebaasist ühe olemasoleva filmi ja küsin selle kohta infot: mis aasta film on ja kui palju on raha teeninud Ameerikas
	//Näide: http://localhost:5555/filmiuuring?filmName=Logan
	//Vastus: Logan on aasta 2017 film ja on teeninud 88411916dollarit Ameerikas
	@RequestMapping("/filmiuuring")
	public String uuring1(String filmName){
		if(filmName==null){
			return "Et otsida, peab olema ka lisatud filmi nimi";
		}
		Filmid film=haldur.findOne(filmName);
		if(film==null){
			return filmName+"- Selline film puudub";
		}
		return filmName + " on aasta "+ film.aasta + " film ja on teeninud " + film.raha + "dollarit Ameerikas";
	}
	
	public static void main(String[] args) {
		System.getProperties().put("server.port", 4207);
		System.getProperties().put("spring.datasource.url", 
		   "jdbc:mysql://localhost:3306/if16_mattbleh_2?useSSL=false");
		System.getProperties().put("spring.datasource.username", "if16");
		System.getProperties().put("spring.datasource.password", "ifikad16");
		SpringApplication.run(Rakendus.class);
	}
}

