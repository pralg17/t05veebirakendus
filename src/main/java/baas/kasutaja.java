package baas;

import javax.persistence.*;

@Entity
@Table(name="kasutajad")

public class kasutaja{
  @Id
  public String kasutajanimi;
  public Float saldo;
}
