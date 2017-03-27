package alar;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by AASA on 13.03.2017.
 */

@Transactional
public interface CCDao extends CrudRepository<CreditCard, Integer> {
}
