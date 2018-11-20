package com.ausecourse.dao;

import java.util.Optional;

import com.ausecourse.model.Order;

public interface IOrderDAO {

	Optional<Order> getById(String id);

	void update(Order order);

	void delete(String id);

	void push(Order user);

}
