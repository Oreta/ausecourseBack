package com.ausecourse.dao;

import java.util.Optional;

import com.ausecourse.model.User;

public interface IUserDao {
public Optional<User> getById(String id);
public void push(User user);
public void emailValide(String user);
}
