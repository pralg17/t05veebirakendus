package ege;

import java.util.*;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ManageTable extends CrudRepository<Animals, Long> {
	List<Animals> findByAnimalName(String animalName);
}