package app;

import java.util.*;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ManageTable extends CrudRepository<Salary, Long> {
	List<Salary> findByLastName(String lastName);
}
