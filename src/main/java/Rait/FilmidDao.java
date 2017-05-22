package Rait;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface FilmidDao extends CrudRepository<Filmid, String> {}