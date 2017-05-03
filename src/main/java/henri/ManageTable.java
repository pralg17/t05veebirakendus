package henri;

import java.util.*;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ManageTable extends CrudRepository<Apartments, Long> {
	List<Apartments> findBycounty(String county);
}