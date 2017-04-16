package tanel;

import javax.persistence.*;

@Table(name="tooted")
@Entity
public class Tooted{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	public String kauplus;
	public String tooteNimi;
	public Integer hind;
	
	
	public Tooted(){
 		
 	}

 	public Tooted(String kauplus, String tooteNimi, Integer hind){
		this.kauplus = kauplus;
		this.tooteNimi = tooteNimi;
		this.hind = hind;
	}	
 	
}