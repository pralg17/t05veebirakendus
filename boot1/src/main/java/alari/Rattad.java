package alari;

import javax.persistence.*;

@Entity
@Table(name = "rattad")

public class Rattad {
	@Id
	public String brand;
	public String model;
	public int price;
	
}