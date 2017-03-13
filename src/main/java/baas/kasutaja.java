package baas;

import javax.persistence.*;

@Entity
@Table(name="inkasso")

public class kasutaja{
  @Id
  public String nimi;
  public Float laen;
  public Float tasutud;
}
