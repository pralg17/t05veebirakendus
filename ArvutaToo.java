package algus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArvutaToo {
   @RequestMapping("/arvuta_too")
   public String arvuta(String mojuvJoud, String teepikkus) {
	   try {
		   int arv1=Integer.parseInt(mojuvJoud);
		   int arv2=Integer.parseInt(teepikkus);
		   
		   return "Keha teeb tööd  " + String.valueOf(arv1*arv2) + " džauli";
	   }
	   
	   catch(Exception ex) {
		   return "Sisesta esimeseks parameetriks mojuvJoud ning teiseks teepikkus. Näide http://localhost:8080/arvuta_too?mojuvJoud=50&teepikkus=2";
    }
  }
}
