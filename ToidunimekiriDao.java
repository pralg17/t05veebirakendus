package karolin;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ToidunimekiriDao extends CrudRepository<Toidunimekiri, Integer> {

}