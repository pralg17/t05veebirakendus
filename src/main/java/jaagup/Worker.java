package jaagup;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="java_employees")
public class Worker{
  @Id
  public String name;
  public int age;
}