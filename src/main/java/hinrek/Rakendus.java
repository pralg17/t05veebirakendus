package hinrek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class Rakendus {
    @Autowired
    private CarDao carDao;

    @RequestMapping("/listall")
    String listall(String mark) {
        StringBuffer sb = new StringBuffer();
        for(Car item : carDao.findAll()){
            sb.append(item);
        }
        String thead = "<tr><th>Id</th><th>Mark</th><th>Mudel</th><th>Voimsus</th></tr>";
        return thead + sb.toString();
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

    @RequestMapping("/kustuta")
    public String kustuta(Integer id) {
        Car car = carDao.findOne(id);
        carDao.delete(car);
        return car.mark + " " + car.mudel + " on kustutatud";
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