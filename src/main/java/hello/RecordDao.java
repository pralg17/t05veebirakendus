package hello;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;

@Transactional
public interface RecordDao extends CrudRepository<Record, Integer> {
}