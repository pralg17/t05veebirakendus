package jaagup;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="j_plants")
public class Plant{
	@Id
	public String name;
	public float hind;
}