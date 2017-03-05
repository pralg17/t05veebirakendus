package algus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArvutaKiirus {
	@RequestMapping("/arvuta_kiirus")
	   public String arvuta(String teepikkus, String aeg) {
		   try {
			   int arv1=Integer.parseInt(teepikkus);
			   int arv2=Integer.parseInt(aeg);
			   
			   return "Keha kiiruseks on " + String.valueOf(arv1/arv2);
		   } 
		   
		   catch(Exception ex) {
			   return "Sisesta esimeseks parameetriks teepikkus ning teiseks aeg. Näide: http://localhost:8080/arvuta_kiirus?teepikkus=10&aeg=1";
		}
	}
}
