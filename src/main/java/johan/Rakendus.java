package johan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Rakendus {

    @Autowired

    private AktsiaHaldur haldur;

    @RequestMapping("/lisa")
    public String lisa(String aktsia, double hind, int kogus, double vaartus) {
        Aktsiad stock = new Aktsiad();
        stock.aktsia = aktsia;
        stock.hind = hind;
        stock.kogus = kogus;
        stock.vaartus = vaartus;
        haldur.save(stock);
        return "Lisatud "+aktsia+" hinnaga "+hind+" eurot ja koguseks "+kogus;
    }

    @RequestMapping("/leia")
    public String leia(String stockName) {
        if (stockName == null) {
            return "Sellist aktsiat ei ole";
        }

        Aktsiad aktsia = haldur.findOne(stockName);
        if (stockName == null) {
            return "Sellist aktsiat ei ole";
        }

        return "Aktsia "+stockName+" on olemas, koguses "+aktsia.kogus+" ja soetus hinnaga "+aktsia.hind;

    }

    public static void main(String[] args) {
        System.getProperties().put("server.port", 4220);
        System.getProperties().put("spring.datasource.url", "jdbc:mysql://localhost:3306/if16_johan?useSSl=false");
        System.getProperties().put("spring.datasource.username", "if16");
        System.getProperties().put("spring.datasource.password", "ifikad16");
        SpringApplication.run(Rakendus.class);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/boot-1.jar