package jaagup;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface Company extends CrudRepository<Worker, String> {
   public Worker findByName(String name);



}

