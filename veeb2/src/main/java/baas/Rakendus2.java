
package t05veebirakendus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Rakendus2 {
    @Autowired
	private MuusikaHaldur haldur;
	
	@RequestMapping("/mituartisti")
    public String artistid(){
        return "Andmebaasis on "+haldur.count() + " artisti";
    }
	

	


	@RequestMapping("/artistiuuring")
    public String artistid1(String musicName){
		if(musicName==null){
			return "Kasutaja määramata";}
		Muusika artist=haldur.findOne(musicName);
		
		if(musicName==null){
			return musicName+" puudub";
			
			
		}
		return "Artist "+musicName+": stiil on "+artist.stiil+" ning on sündinud aastal "+artist.synniaasta+".";
    }
    
	
	
	
    public static void main(String[] args) {
        System.getProperties().put("server.port", 1256);
		System.getProperties().put("spring.datasource.url", "jdbc:mysql://localhost:3306/if16_kriskand?useSSl=false");
		System.getProperties().put("spring.datasource.username", "if16");
		System.getProperties().put("spring.datasource.password", "ifikad16");
		SpringApplication.run(Rakendus2.class);
    }
	
		
}


// scl enable rh-maven33 bash
//dir pom/xml
// mvn package
// java -jar target/t05veebirakendus-0.0.1-SNAPSHOT.jar

/* greenys tekitame tabeli juurde duplicate session


mysql -uif16 -pifikad16

uus file
CREATE TABLE kasutajad(
	kasutajanimi VARCHAR(30) NOT NULL PRIMARY KEY,
	saldo DECIMAL(8, 2)

);

INSERT INTO kasutajad VALUES ('juhan', 10);

package baas;

import javax.persitence.*

@Entity
@Table(name="kasutajad")
public class Kasutaja{
	@Id
	
	
}


CREATE TABLE muusika(
	artist VARCHAR(30) NOT NULL PRIMARY KEY,
	stiil VARCHAR(50) NOT NULL,
	synniaasta INT NOT NULL
);

INSERT INTO muusika VALUES ('Eminem', 'Hip hop', '1972');
INSERT INTO muusika VALUES ('Chance_the_Rapper', 'Hip hop', '1993');
INSERT INTO muusika VALUES ('Jimi_Hendrix', 'Psychedelic rock', '1942');



*/