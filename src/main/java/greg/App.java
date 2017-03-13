package greg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
		System.getProperties().put("server.port", 4299);
        SpringApplication.run(App.class, args);
    }

}