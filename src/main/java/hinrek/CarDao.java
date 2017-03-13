package hinrek;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CarDao extends CrudRepository<Car, Integer> {

}