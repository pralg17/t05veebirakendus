package hinrek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class Rakendus {
    @Autowired
    private CarDao carDao;

    @RequestMapping("/")
    @ResponseBody
    String kodukas() {

        return "<h1>Tervitused!</h1>" +
                "<h2>Valige tegevus</h2>" +
                "<a href=\"/leiamark\">Otsi margi alusel</a><br>" +
                "<a href=\"/lisa\">Lisa auto baasi</a><br>" +
                "<a href=\"/leiamudel\">Otsi mudeli alusel</a><br>";
    }

    @RequestMapping("/leiamark")
    String leiamark(String mark) {
        Car car = carDao.findByMark(mark);

        return " mark " + mark + " mudel " + car.mudel + " voimsus " + car.voimsus;
    }

    @RequestMapping("/leiamudel")
    String leiamudel(String mudel) {
        Car car = carDao.findByMudel(mudel);

        return " mark " + car.mark + " mudel " + mudel + " voimsus " + car.voimsus;
    }

    @RequestMapping("/lisa")
    String lisa(String mark, String mudel, Integer voimsus) {
        Car car = new Car();
        car.mark = mark;
        car.mudel = mudel;
        car.voimsus = voimsus;
        carDao.save(car);
        return "Lisatud " + mark + mudel + voimsus;
    }

    public static void main(String[] args) {
        System.getProperties().put("server.port", 4201);
        SpringApplication.run(Rakendus.class, args);
    }
}

// http://localhost:4201/leiamark?mark=Volvo
// id 4 mark Volvo mudel s40 voimsus 420

// http://localhost:4201/leiamudel?mudel=RS6
// mark Audi mudel RS6 voimsus 666