package elle;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface laohaldur extends CrudRepository<tooted, String>{

}
