package riff;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planets")
public class Planet{
    @Id
    public String name;
    public Float fromSun;
    public Float speed;
}
