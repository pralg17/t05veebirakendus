package hinrek;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface CarDao extends CrudRepository<Car, Integer> {

}