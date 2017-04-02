package jaagup;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="raamatud")
public class raamatud{
  @Id
  public String title;
  public String author;
  public int isbn;
}

