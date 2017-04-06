package app;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application{
    @Autowired
	private ManageTable manager;

	@RequestMapping("/create")
	String create(String firstName, String lastName, Integer salary){
		manager.save(new Salary(firstName, lastName, salary));
		return "Salary saved!";
	}

    @RequestMapping("/search")
    String Search(String lastName){
        if(lastName.isEmpty()){return "no info";}
        List<Salary> salary=manager.findByLastName(lastName);
        if(salary.isEmpty()){return lastName+" not found";}
		StringBuffer sb = new StringBuffer();
		for(Salary person: salary){
			sb.append("<p>");
			sb.append(lastName +" salary: "+person.salary.toString());
			sb.append("</p>");
		}
		return sb.toString();
    }
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

}