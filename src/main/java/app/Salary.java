package app;

import javax.persistence.*;

@Entity
@Table(name="Salaries")
public class Salary {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
    public String firstName;
    public String lastName;
	public Integer salary;
	public Salary(){
		
	}
	public Salary(String firstName, String lastName, Integer salary){
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		
	}
}
