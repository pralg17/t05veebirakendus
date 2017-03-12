package hinrek;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface CarDao extends CrudRepository<Car, Long> {
    Car findByMark(String mark);
    Car findByMudel(String mudel);
}