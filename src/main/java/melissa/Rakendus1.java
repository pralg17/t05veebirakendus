package melissa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Rakendus1{
  @Autowired
  private haldur haldur;

  @RequestMapping ("/lisamine")
  public String lisamine1(String nimi, int hinne, int puudumised){
    if(nimi==null){return "nimi m‰‰ramata";}
      hinne k=haldur.findOne(nimi);
      if(k==null){
        return nimi+" puudub";
      }
      k.hinne=hinne;
      k.puudumised=puudumised;
      haldur.save(k);
      return uuring1(nimi);
  }
  @RequestMapping("/puudumisteuuring")
  public String uuring1(String nimi){
    if(nimi==null){return "nimi m‰‰ramata";}
      hinne k=haldur.findOne(nimi);
      if(k==null){
        return nimi+" puudub";
      }
    return nimi+" ta hinne oli "+k.hinne " ja ta puudus "+k.puudumised " tunde";
  }

	public static void main(String[] args) {
    System.getProperties().put("server.port", "4217");
    System.getProperties().put("spring.datasource.url", "jdbc:mysql://localhost:3306/if16_melissab?useSSL=false");
    System.getProperties().put("spring.datasource.username", "if16");
    System.getProperties().put("spring.datasource.password", "ifikad16");
		SpringApplication.run(rak.class);
	}
}