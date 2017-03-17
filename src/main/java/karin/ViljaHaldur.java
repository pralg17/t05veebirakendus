package karin;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface ViljaHaldur extends CrudRepository<Vili, String>{
		
}