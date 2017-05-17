package lilith;

import java.util.*;
import java.lang.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class Application{
	
	@Autowired
	private StudentTable table;
	
	@RequestMapping("/")
	public String index(){
		return "Index";
	}
	
	@RequestMapping("/save")
	public String save(String firstName, String lastName, Integer grade){
		table.save(new StudentEntity(firstName, lastName, grade));
		return "student saved";
	}
	@RequestMapping("/search")
	public String search(Integer grade){
		if(grade==null){return "no info";}
		List<StudentEntity> students=table.findByGrade(grade);
		if(students.isEmpty()){return grade+" not found";}
		StringBuffer sb = new StringBuffer();
		for(StudentEntity student: students){
			sb.append("<p>");
			sb.append(student.lastName+" grade: "+student.grade.toString());
			sb.append("</p>");
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		System.getProperties().put("server.port", 4200);
		SpringApplication.run(Application.class, args);
	}
}
//scl enable rh-maven33 bash
//mvn package && java -jar target/lilith-1.jar