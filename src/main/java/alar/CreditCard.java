package alar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by AASA on 13.03.2017.
 */

@Entity
@Table(name="creditcards")
public class CreditCard {
    @Id
    Integer cardnumber;
    Integer cvv;
    String expidate;

    @Override
    public String toString(){
        return cardnumber + " " + cvv + " " + expidate + " ";
    }
}
