package henri;

import javax.persistence.*;

@Table(name="apartments")
@Entity
public class Apartments{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	public String apartment;
	public String county;
	public Integer price;
	
	
	public Apartments(){
 		
 	}

 	public Apartments(String apartment, String county, Integer price){
		this.apartment = apartment;
		this.county = county;
		this.price = price;
	}	
 	
}