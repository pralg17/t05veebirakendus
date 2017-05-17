package lilith;

import javax.persistence.*;

@Table(name="Students")
@Entity

public class StudentEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	public String firstName;
	public String lastName;
	public Integer grade;
	
	public StudentEntity(){
		
	}
	public StudentEntity(String firstName, String lastName, Integer grade){
		this.firstName=firstName;
		this.lastName=lastName;
		this.grade=grade;
	}
	
}