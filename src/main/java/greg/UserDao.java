package greg;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;


@Transactional
public interface UserDao extends CrudRepository<User, Long> {

  /**
   * This method will find an User instance in the database by its email.
   * Note that this method is not implemented and its working code will be
   * automagically generated from its signature by Spring Data JPA.
   */
  public User findByEmail(String email);

}

/*
/create?email=[email]&name=[name]
/delete?id=[id]
/get-by-email?email=[email]
/update?id=[id]&email=[email]&name=[name]