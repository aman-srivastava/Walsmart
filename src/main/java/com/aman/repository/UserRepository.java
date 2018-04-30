package com.aman.repository;

import com.aman.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by asriva26 on 04/25/18.
 */
public interface UserRepository extends CrudRepository<User, Long>{

}
