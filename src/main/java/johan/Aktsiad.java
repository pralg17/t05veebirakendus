package johan;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aktsiad")

public class Aktsiad{
    @Id
    public String aktsia;
    public double hind;
    public int kogus;
    public double vaartus;
}