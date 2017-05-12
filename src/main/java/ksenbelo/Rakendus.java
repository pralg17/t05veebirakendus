package ksenbelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@SpringBootApplication
public class Rakendus{
	
	@Autowired
	private MangudenimikiriTab mangudenimikiriTab;
	
	
	@RequestMapping("/helo")
	String tervitusfunktsioon(){
		return "hello!";
	}
	
	@RequestMapping("/mangud")
	public String magnud2(){
		String str = "Mängud:</br>";
		for (mangudenimekiri mangudenimekiri: mangudenimikiriTab.findAll()){
		str = str + mangudenimekiri.title + " " + mangudenimekiri.year + " " + mangudenimekiri.cost;
		str += "</br>";
		}
		return str;
	}
	/*
		Mängud:
	The Sims 4 2014 40
	The Sims 3 2013 30
	Batlefield 1 2016 60
	TheSims3 2013 30
	*/
	
    @RequestMapping("/lisa")
    String lisa(String title, Integer year, Integer cost) {
        mangudenimekiri mangudenimekiri = new mangudenimekiri();
        mangudenimekiri.title = title;
        mangudenimekiri.year = year;
		mangudenimekiri.cost = cost;
        mangudenimikiriTab.save(mangudenimekiri);
        return "Lisatud " + title + year + cost;
    }
	/*
	http://localhost:5246/lisa?title=TheSims3&year=2013&cost=30
	*/
	
    public static void main(String[] args) {
        System.getProperties().put("server.port", 5254);
        SpringApplication.run(Rakendus.class, args);
	}
	
}

