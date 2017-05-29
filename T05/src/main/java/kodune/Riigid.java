package kodune;

import javax.persistence.*;



@Entity
@Table(name="riigiandmed")
public class Riigid{
	@Id
	public String riik;
	public int rahvaarv;
	public int pindala;
}
