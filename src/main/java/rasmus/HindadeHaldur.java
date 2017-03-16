package rasmus;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface HindadeHaldur extends CrudRepository<Hinnad, String>{

}	