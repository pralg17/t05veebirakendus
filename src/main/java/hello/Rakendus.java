package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Rakendus {
    private final RecordDao recordDao;

    @Autowired
    public Rakendus(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    @RequestMapping("/listall")
     String listall(String mark) {
        StringBuffer sb = new StringBuffer();
        for (Record item : recordDao.findAll()) {
            sb.append(item);
        }
        String thead = "<tr><th>Id</th> <th>Artist</th> <th>Name</th ><th>Label</th> <th>Year</th> <th>Rating</th></tr>";
        return thead + sb.toString();
    }

    @RequestMapping("/lisa")
    String lisa(String artist, String name, String label, Integer year, String rating) {
        Record record = new Record();
        record.artist = artist;
        record.name = name;
        record.label = label;
        record.year = year;
        record.rating = rating;
        recordDao.save(record);
        return "Lisatud " + artist + name + label + year + rating;
    }

    public static void main(String[] args) {
        System.getProperties().put("server.port", 4207);
        SpringApplication.run(Rakendus.class, args);
    }
}