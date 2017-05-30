package gittkaus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class rakendus{
  @Autowired
  private info info;

  @RequestMapping ("/lisamine")
  public String lisamine(String nimi, int hinded, int puudumine){
    if(nimi==null){return "Nimi puudub";}
      hinded k=info.findOne(nimi);
      if(k==null){
        return "Õpilast " +nimi+" pole";
      }
      k.hinded=hinded;
      k.puudumine=puudumine;
      info.save(k);
      return uuring(nimi);
  }
  @RequestMapping("/puudumisteuuring")
  public String uuring(String nimi){
    if(nimi==null){return "Nimi puudub";}
      hinded k=info.findOne(nimi);
      if(k==null){
        return "Õpilast" +nimi+" pole";
      }
    return "Õpilase" +nimi+" hinded oli "+k.hinded+ " ja ta puudus "+k.puudumine+ " tunde";
  }

	public static void main(String[] args) {
    System.getProperties().put("server.port", "8080");
    System.getProperties().put("spring.datasource.url", "jdbc:mysql://localhost/if16_gittkaus_3?useSSL=false");
    System.getProperties().put("spring.datasource.username", "if16");
    System.getProperties().put("spring.datasource.password", "ifikad16");
		SpringApplication.run(rakendus.class);
	}
}