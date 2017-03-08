package t05veebirakendus;
import javax.persistence.*;
@Entity
@Table(name="filmid")
public class Filmid{
	@Id
	public String nimi;
	public int aasta;
	public int raha;
}