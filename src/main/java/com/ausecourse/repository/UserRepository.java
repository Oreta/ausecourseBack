package com.ausecourse.repository;

import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ausecourse.model.User;

//terminée
@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
