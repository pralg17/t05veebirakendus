package baas;

import javax.persistence.*;

@Entity
@Table(name="autod")

public class Kasutaja{
  @Id
  public String omanik;
  public String mark;
  public String mudel;
  public int aasta;
  public int voimsus;
}
