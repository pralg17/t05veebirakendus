package vlasn;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inimesed")
public class Inimene{
  @Id
  public String isikukood;
  public double pikkus;
  public double kaal;
  public Integer vanus;
}