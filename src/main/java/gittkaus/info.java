package gittkaus;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface info extends CrudRepository<hinded, String>{

}