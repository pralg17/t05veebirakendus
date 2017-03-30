package johan;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface RattaHaldur extends CrudRepository<Rattad, String> {
	
}