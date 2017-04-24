package melissa;

import javax.persistence.*;

@Entity
@Table(name="hinne")
public class hinne{
  @Id
  public String nimi;
  public int hinne;
  public int puudumised;
}