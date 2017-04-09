package jaagup;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workers")
public class Worker{
  @Id
  public String name;
  public int age;
}