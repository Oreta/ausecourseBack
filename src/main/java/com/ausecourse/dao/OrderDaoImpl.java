package com.ausecourse.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ausecourse.model.Order;
import com.ausecourse.model.OrderState;
import com.ausecourse.model.User;
import com.ausecourse.repository.OrderRepository;


public class OrderDaoImpl implements IOrderDAO {
	

@Autowired
OrderRepository orderRepository;
	
	@Override
	public Optional<Order> getById(String id) {

			return orderRepository.findById(id);
	}


	@Override
	public void push(Order user) {
		orderRepository.save(user);
		
	}




	@Override
	public void delete(String id) {
		Order order = orderRepository.findById(id).get();
		order.setOrderState(OrderState.CANCEL);
		orderRepository.save(order);
		
	}


	@Override
	public void update(Order order) {
		orderRepository.save(order);
		
	}

}
