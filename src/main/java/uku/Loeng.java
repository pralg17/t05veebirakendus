package uku;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loengud")
public class Loeng{
  @Id
  public String ruhm;
  public String algus;
  public String lopp;
  public String paev;
}