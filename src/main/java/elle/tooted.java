package elle;

import javax.persistence.*;

@Entity
@Table (name="tooted")
public class tooted{
	@Id
	public String jook;
	public String nimi;
	public Double kogus;
}
