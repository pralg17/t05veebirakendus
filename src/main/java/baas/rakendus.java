package baas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication

public class rakendus {
  @Autowired
  private kasutajahaldur haldur;

  @RequestMapping("/lisamine")
  public String lisamine1(String knimi, float kogus){
    if (knimi==null) {return "kasutaja määramata";}

    kasutaja k = haldur.findOne(knimi);
    if (k==null) {return knimi+ " puudub";}

    k.saldo=k.saldo+kogus;
    haldur.save(k);
    return uuring1(knimi);
  }

  @RequestMapping("/rahauuring")
  public String uuring1(String knimi){
    kasutaja k = haldur.findOne(knimi);
    if (k==null) {
      return knimi+ " puudub";
    }
    return knimi+" kontol "+k.saldo;
  }

  @RequestMapping("/tervitusleht")

    public String tervitus(String eesnimi){
      return "Tere "+eesnimi+"!";
    }

  public static void main(String[] args){
      System.getProperties().put("server.port", 1117);
      System.getProperties().put("spring.datasource.url","jdbc:mysql://localhost:3306/if16_taneotsa_4?useSSL=false");
      System.getProperties().put("spring.datasource.username","if16");
      System.getProperties().put("spring.datasource.password","ifikad16");
    SpringApplication.run(rakendus.class);
  }
}
