package krister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Rakendus {
	@RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Ahoi!";
    }
	@RequestMapping("/determinant")
		String gk(String arv1, String arv2, String arv3, String arv4, String arv5, String arv6, String arv7, String arv8, String arv9){
				int a1=Integer.parseInt(arv1);
				int b1=Integer.parseInt(arv4);
				int b2=Integer.parseInt(arv5);
				int b3=Integer.parseInt(arv6);
				int c1=Integer.parseInt(arv7);
				int c2=Integer.parseInt(arv8);
				int c3=Integer.parseInt(arv9);
			if(a1==1){
				return "Vektorkorrutis i "+ (b2*c3-b3*c2)+" j "+(b3*c1-b1*c3)+" k "+(b1*c2-b2*c1);
			} else {
				int a2=Integer.parseInt(arv2);
				int a3=Integer.parseInt(arv3);

				return "Determinant "+ (a1*b2*c3+a2*b3*c1+a3*b1*c2-a3*b2*c1-a1*b3*c2-a2*b1*c3);
			}
}

    public static void main(String[] args) {
		//System.getProperties().put("server.port", 35878);
        SpringApplication.run(Rakendus.class, args);

}
}

//scl enable rh-maven33 bash tellib pakku kaasa
//mvn package compileerib
//java -jar target/boot3-1.0-SNAPSHOT.jar commpileerib koodi