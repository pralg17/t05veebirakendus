package baas;

import javax.persistence.*;

@Entity
@Table(name="Hinded")
public class Hinded{
  @Id
  public String aine;
  public int hinne;
  public int eap;
}
