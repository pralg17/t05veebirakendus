package hinrek;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// Class must be public (intellij is retarded)
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue
    Integer id;
    String mark;
    String mudel;
    Integer voimsus;

    @Override
    public String toString() {
        return "<tr><td>" + id + "</td><td>" + mark + "</td><td>" + mudel + "</td><td>" + voimsus + "</td></tr>";
    }
}