package edgar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customers{
  @Id
  public String name;
  public String surname;
  public String email;
  public int number;
}