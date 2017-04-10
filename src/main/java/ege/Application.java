package ege;

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
	String create(String animalName, Integer age){
		manager.save(new Animals(animalName, age));
		return "animal saved";
	}
	
	@RequestMapping("/search")
    String Search(String animalName){
        if(animalName.isEmpty()){return "no info";}
        List<Animals> animals=manager.findByAnimalName(animalName);
        if(animals.isEmpty()){return animalName+" not found";}
		StringBuffer sb = new StringBuffer();
		for(Animals animal: animals){
			sb.append("<p>");
			sb.append(animalName +" age: "+animal.age.toString());
			sb.append("</p>");
		}
		return sb.toString();

	}
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
	
}



