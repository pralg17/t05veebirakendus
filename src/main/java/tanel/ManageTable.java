package tanel;

import java.util.*;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ManageTable extends CrudRepository<Tooted, Long> {
	List<Tooted> findBytooteNimi(String tooteNimi);
}