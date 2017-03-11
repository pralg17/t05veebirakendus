package Chris;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface VGameManager extends CrudRepository<vgames, String> {
}