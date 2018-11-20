package com.ausecourse.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ausecourse.model.Order;
import com.ausecourse.model.User;


@Autowired
OrderRepository orderRepositor
public class OrderDaoImpl implements IOrderDAO {
	
	@Override
	public Optional<Order> getById(String id) {

			return order.findById(id);
	}


	@Override
	public void push(User user) {
		orderRepository.save(user);
		
	}




	@Override
	public void delete(String id) {
		Order order = orderRepository.findById(id).get();
		
		userRepository.save(user);
		
	}


	@Override
	public void update(User user) {
		userRepository.save(user);
		
	}

}
