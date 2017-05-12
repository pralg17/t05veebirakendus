package ksenbelo;

import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;

@Transactional
public interface MangudenimikiriTab extends CrudRepository<mangudenimekiri, Integer> {

}