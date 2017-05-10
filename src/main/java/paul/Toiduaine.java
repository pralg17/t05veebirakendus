package paul;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="toiduained")
public class Toiduaine{
  @Id
  public String name;
  public int price;
}