package paul;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface Pood extends CrudRepository<Toiduaine, String> {
   public Toiduaine findByName(String name);



}
