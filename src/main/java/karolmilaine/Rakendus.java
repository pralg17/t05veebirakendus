package karolmilaine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Rakendus {
    private final ToidunimekiriDao toidunimekiriDao;

    @Autowired
    public Rakendus(ToidunimekiriDao toidunimekiriDao) {
        this.toidunimekiriDao = toidunimekiriDao;
    }

    @RequestMapping("/listall")
    String listall(String food) {
        StringBuffer sb = new StringBuffer();
        for (Toidunimekiri item : toidunimekiriDao.findAll()) {
            sb.append(item);
        }
        String thead = "<tr><th>Id</th><th>Food</th><th>Amount</th></tr>";
        return thead + sb.toString();
    }

    @RequestMapping("/lisa")
    String lisa(String food, Integer amount) {
        Toidunimekiri toidunimekiri = new Toidunimekiri();
        toidunimekiri.food = food;
        toidunimekiri.amount = amount;
        toidunimekiriDao.save(toidunimekiri);
        return "Lisatud " + food + amount;
    }

    @RequestMapping("/kustuta")
    String kustuta(Integer id) {
        Toidunimekiri toidunimekiri = toidunimekiriDao.findOne(id);
        toidunimekiriDao.delete(toidunimekiri);
        return toidunimekiri.food + " " + toidunimekiri.amount + " on kustutatud";
    }

    public static void main(String[] args) {
        System.getProperties().put("server.port", 5555);
        SpringApplication.run(Rakendus.class, args);
    }
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/rakendus-1.jar