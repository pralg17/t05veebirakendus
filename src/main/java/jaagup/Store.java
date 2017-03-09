package jaagup;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface Store extends CrudRepository<Plant, String>{
	public Plant findByName(String name);
}