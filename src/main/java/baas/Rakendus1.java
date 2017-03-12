package baas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController

public class Rakendus1 {
  /*
  @RequestMapping("/lisamine")
  public String lisamine1(String knimi, float kogus){
    if(knimi==null){return "Kasutaja määramata";}
    Kasutaja k=haldur.findOne(knimi);
    if(k==null){
      return knimi+" puudub";
    }
    k.saldo=k.saldo+kogus;
    haldur.save(k);
    return uuring1(knimi);
  }
  */

  @Autowired
  private KasutajateHaldur haldur;

  @RequestMapping("/uuring")
  public String uuring1(String knimi){
    Kasutaja k=haldur.findOne(knimi);
    if(k==null){
      return knimi+" puudub";
    }
    return knimi+" auto: "+k.mark + " " + k.mudel + " " + k.aasta + "a. "+ k.voimsus+ "kW";
  }

  @RequestMapping("/tervitusleht1")
   public String tervitus1(String eesnimi) {

       return "Tere, "+eesnimi+"!";
   }

    public static void main(String[] args) {
      System.getProperties().put("server.port", 4302);
      System.getProperties().put("spring.datasource.url","jdbc:mysql://localhost:3306/if16_kentloog?useSSL=false");
      System.getProperties().put("spring.datasource.username", "if16");
      System.getProperties().put("spring.datasource.password", "ifikad16");

        SpringApplication.run(Rakendus1.class);
    }
}
