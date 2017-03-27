package t05veebirakendus;
import javax.persistence.*;
@Entity
@Table(name="muusika")
public class Muusika{
	@Id
	public String artist;
	public String stiil;
	public int synniaasta;
}