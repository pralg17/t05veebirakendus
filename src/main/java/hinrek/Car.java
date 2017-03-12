package hinrek;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Class must be public (intellij is retarded)
@Entity
@Table(name = "cars")
public class Car {
    @Id
    String mark;
    String mudel;
    int voimsus;
}