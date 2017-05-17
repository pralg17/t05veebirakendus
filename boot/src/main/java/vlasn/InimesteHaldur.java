package vlasn;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface InimesteHaldur extends CrudRepository<Inimene, String> {
   public Inimene findByIsikukood(String isikukood);
}