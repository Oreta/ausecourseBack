package com.ausecourse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ausecourse.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
