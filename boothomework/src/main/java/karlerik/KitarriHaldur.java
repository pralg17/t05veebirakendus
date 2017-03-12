package karlerik;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface KitarriHaldur extends CrudRepository<Kitarrid, Integer> {
	
}