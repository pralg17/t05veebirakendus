package ege;

import javax.persistence.*;

@Table(name="Animals")
@Entity
public class Animals{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	public String animalName;
	public Integer age;
	
	
	public Animals(){
 		
 	}

 	public Animals(String animalName, Integer age){
		this.animalName = animalName;
		this.age = age;
	}	
 	
}