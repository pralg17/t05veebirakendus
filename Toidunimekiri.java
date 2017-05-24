package karolin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "toidunimekiri")
public class Toidunimekiri {
    @Id
    @GeneratedValue
    Integer id;
    String food;
    Integer amount;

    @Override
    public String toString() {
        return "<tr><td>" + id + "</td><td>" + food + "</td><td>" + amount + "</td><td>";
    }
}