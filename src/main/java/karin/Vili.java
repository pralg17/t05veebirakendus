package karin;
 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="viljad")
public class Vili{
	@Id
 	public String nimi;
 	public float hind;
	public float kogus;
} 