package alar;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@SpringBootApplication
public class Rakendus {
    public final CCDao ccDao;

    @Autowired
    public Rakendus(CCDao ccDao){
        this.ccDao = ccDao;
    }

    @RequestMapping("/getCards")
    String getCards(){
        StringBuffer sb = new StringBuffer();
        for (CreditCard item : ccDao.findAll()){
            sb.append(item);
        }
        return sb.toString();
    }

    @RequestMapping("/add")
    public String add(Integer cardnumber, Integer cvv, String expidate){
        CreditCard creditCard = new CreditCard();
        String cards = getCards();
        String[] allCards = cards.split(" ");
        for(int i=0; i<allCards.length; i+=3){
            if(Integer.toString(cardnumber).equals(allCards[i])){return "Card is stolen! Sorry.";}
        }
        creditCard.cardnumber = cardnumber;
        creditCard.cvv = cvv;
        creditCard.expidate = expidate;
        ccDao.save(creditCard);
        return "Credit card not stolen!";
    }

    public static void main(String[] args) {
        System.getProperties().put("server.port", 4424);
        SpringApplication.run(Rakendus.class, args);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar