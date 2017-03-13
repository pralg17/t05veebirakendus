package greg;

import greg.Tere;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TereController {

    @GetMapping("/tere")
    public String tereForm(Model model) {
        model.addAttribute("tere", new Tere());
        return "tere";
    }

    @PostMapping("/tere")
    public String tereSubmit(@ModelAttribute Tere tere, String content) {
   	String msgId = "";
    try {
      Tere msg = new Tere(content);
      tereDao.save(msg);
      msgId = String.valueOf(msg.getId());
    } catch (Exception ex) {
    	return "Error submitting message";
    }
        return "result";
    }


  @Autowired
  private TereDao tereDao;
  
}