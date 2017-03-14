package baas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class rak{
  @Autowired
  private Hhaldur haldur;

  @RequestMapping ("/lisamine")
  public String lisamine1(String animi, int hinne, int eap){
    if(animi==null){return "Ainenimi määramata";}
      Hinded k=haldur.findOne(animi);
      if(k==null){
        return animi+" puudub";
      }
      k.hinne=hinne;
      k.eap=eap;
      haldur.save(k);
      return uuring1(animi);
  }
  @RequestMapping("/hindeuuring")
  public String uuring1(String animi){
    if(animi==null){return "Aine määramata";}
      Hinded k=haldur.findOne(animi);
      if(k==null){
        return animi+" puudub";
      }
    return animi+" hindeks on "+k.hinne;
  }

	public static void main(String[] args) {
    System.getProperties().put("server.port", "1716");
    System.getProperties().put("spring.datasource.url", "jdbc:mysql://localhost:3306/if16_karroo?useSSL=false");
    System.getProperties().put("spring.datasource.username", "if16");
    System.getProperties().put("spring.datasource.password", "ifikad16");
		SpringApplication.run(rak.class);
	}
}
