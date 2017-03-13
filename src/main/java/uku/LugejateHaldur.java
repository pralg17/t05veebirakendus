package uku;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface LugejateHaldur extends CrudRepository<Lugeja, Long> {
   public Lugeja findByEmail(String email);
}