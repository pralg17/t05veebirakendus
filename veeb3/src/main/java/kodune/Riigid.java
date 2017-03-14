package kodune;

import javax.persistence.*;

/* @Entity
@Table(name="kasutajad")
public class Kasutaja{
	@Id
	public String kasutajanimi;
	public float saldo;
} */

@Entity
@Table(name="riigiandmed")
public class Riigid{
	@Id
	public String riik;
	public int rahvaarv;
	public int pindala;
}