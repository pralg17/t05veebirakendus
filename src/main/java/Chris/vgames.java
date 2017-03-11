package Chris;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vgames")
public class vgames{
  @Id
  public String title;
  public String platform;
  public int sales;
}