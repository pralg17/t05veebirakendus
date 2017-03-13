package riff;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface PlanetData extends CrudRepository<Planet, String> {
   public Planet findByName(String name);
} 
