package heino;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface MenyyHaldur extends CrudRepository<Toidud, String> {

}
