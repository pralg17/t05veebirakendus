package edgar;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface customerManager extends CrudRepository<Customers, String> {
	  public Customers findByName(String name);
}