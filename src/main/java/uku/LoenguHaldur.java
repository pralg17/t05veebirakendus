package uku;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface LoenguHaldur extends CrudRepository<Loeng, Long> {
   public Loeng findByRuhm(String ruhm);
}