package gittkaus;

import javax.persistence.*;

@Entity
@Table(name="hinded")
public class hinded{
  @Id
  public String nimi;
  public int hinded;
  public int puudumine;
}