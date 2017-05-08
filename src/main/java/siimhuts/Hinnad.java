package siimhuts;

import javax.persistence.*;

@Entity
@Table(name="hinnad")
public class Hinnad{
	@Id
	public String ese;
	public float hind;
}
