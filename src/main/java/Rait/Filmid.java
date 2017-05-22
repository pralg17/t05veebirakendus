package Rait;

import javax.persistence.*;

@Entity
@Table(name="filmid")

public class Filmid {
	@Id
	public String nimi;
	public int aasta;
	public String seis;
	public int pikkus;

}