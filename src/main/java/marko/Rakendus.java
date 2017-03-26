package marko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Rakendus {

    @RequestMapping("/algarv")
    public String getPrime(String number) {
        int i;


        try {
            int converted_number = Integer.parseInt(number);
            String answer = "";
            for (i = 1; i < converted_number; i++) {

                if (converted_number % i == 0 && i != 1) {
                    answer = "Ei ole algarv";
                }
            }

            return answer;


        } catch (Exception e) {
            return "Sisend ei ole arv";
        }


    }


    public static void main(String[] args) {
        System.getProperties().put("server.port", 4245);
        SpringApplication.run(Rakendus.class, args);
    }
}