package com.ausecourse.dao;

import java.util.Optional;

import com.ausecourse.model.User;

public interface IUserDao {
public Optional<User> getById(String id);
}
