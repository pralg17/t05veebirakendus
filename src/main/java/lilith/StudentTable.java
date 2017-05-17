package lilith;

import java.util.*;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface StudentTable extends CrudRepository<StudentEntity, Long> {
	List<StudentEntity> findByGrade(Integer grade);
}