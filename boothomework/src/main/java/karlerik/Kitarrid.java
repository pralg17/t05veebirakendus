package karlerik;

import javax.persistence.*;
import java.text.DecimalFormat;

@Entity
@Table(name = "kitarrid")

public class Kitarrid {
	@Id
	@GeneratedValue
	public int id;
	public String brand;
	public String model;
	public int price;
	public int strings;
	public String type;
	
	@Override
	public String toString() {
		DecimalFormat format = new DecimalFormat("0.00");
		String guitarType = (type.equals("r"))?"righthanded":"lefthanded";
		return "<tr><td>" + id + "</td><td>" + brand + "</td><td>" + model + "</td><td>" +
			format.format(price) + "</td><td>" + strings + "</td><td>" + guitarType + "</td></tr>";
	}
}