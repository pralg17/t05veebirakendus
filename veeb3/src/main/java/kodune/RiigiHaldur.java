package kodune;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface RiigiHaldur extends CrudRepository<Riigid, String>{
	
}