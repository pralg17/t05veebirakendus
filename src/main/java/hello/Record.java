package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Record {
	@Id
	@GeneratedValue
	Integer id;
	String artist;
	String name;
	String label;
	Integer year;
	String rating;

	@Override
	public String toString() {
		return "<tr><td>" + id + "</td><td>" + artist + "</td><td>" + name + "</td><td>" + label + "</td><td>"+ year +
				"</td><td>" + rating + "</td></tr>";
	}
}