package johan;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface AktsiaHaldur extends CrudRepository<Aktsiad, String>{
    
}