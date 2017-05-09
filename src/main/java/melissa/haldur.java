package melissa;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface haldur extends CrudRepository<hinne, String>{

}