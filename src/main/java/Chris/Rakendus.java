package Chris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@SpringBootApplication
public class Rakendus{
	@Autowired
	private VGameManager vgamemanager;
	
	@RequestMapping("/find")
	String find(String title){
		if(title == null){
			return "Please enter a valid title";
		}
		vgames vgame = vgamemanager.findOne(title);
		if(vgame == null){
			return "The title you requested does not exist";
		}
		return "Title:" + title + "</br>Platform: " + vgame.platform + "</br>Sales: " + vgame.sales;
	}
	
	@RequestMapping("/total")
	public String total(){
		return "There are qurrently " + vgamemanager.count() + " entries in this database";
	}
	
	@RequestMapping("/showAll")
	public String all(){
		
		String data_string = "";
		int index = 0;
		
		for(vgames vgame : vgamemanager.findAll()){
			index += 1;
			data_string = data_string + index + "  " + "    " + vgame.title + "    " + vgame.platform + "    " + vgame.sales;
			data_string += "</br>";
		}
		
		return data_string;
		
	}
	
	@RequestMapping("/addNewGame")
	public String new_game(String title, String platform, int sales){
		if(title == null || platform == null || sales == 0){
			return "Please fill in all of the details";
		}
		vgames n_game = new vgames();
		n_game.title = title;
		n_game.platform = platform;
		n_game.sales = sales;
		vgamemanager.save(n_game);
		return "Added a new game " + title;
	}
	
	public static void main(String[] args){
		System.getProperties().put("server.port", 4206);
		SpringApplication.run(Rakendus.class);
	}
}