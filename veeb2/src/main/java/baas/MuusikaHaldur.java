package t05veebirakendus;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface MuusikaHaldur extends CrudRepository<Muusika, String>{
	
	
}