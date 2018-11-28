package com.ausecourse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ausecourse.dao.IOrderDAO;
import com.ausecourse.model.Order;
import com.ausecourse.model.OrderState;
import com.ausecourse.model.User;
import com.ausecourse.repository.OrderRepository;
import com.ausecourse.repository.UserRepository;


@Service
public class OrderDaoImpl implements IOrderDAO {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public Order getById(int id) {

		return orderRepository.findById(id).get();
	}

	@Override
	public void push(Order order) {

		orderRepository.save(order);

	}

	@Override
	public void delete(int id) {
		Order order = orderRepository.findById(id).get();
		order.setOrderState(OrderState.CANCEL);
		orderRepository.save(order);

	}

	@Override
	public void update(Order order) {
		orderRepository.save(order);

	}

	@Override
	public List<User> deliverer(String idClient, int idOrder) {

		User client = userRepository.findById(idClient).get();
		ArrayList<User> listAll = (ArrayList<User>) userRepository.findAll();
		ArrayList<User> listReturn = new ArrayList<User>();
		for (User user : listAll) {
			if (user.getCity().equals(client.getCity()) && user.isDeliverer()) { // todo change whit google map
																					// librairy.
				listReturn.add(user);
			}
		}

		return listReturn;

	}

	@Override
	public void deliveredChoice(int idOrder, String idLiveur) {

		Order order = orderRepository.findById(idOrder).get();
		order.setLivreurId(idLiveur);
		orderRepository.save(order);

	}

	@Override
	public void cancelOrder(int idOrder) {
		Order order = orderRepository.findById(idOrder).get();
		order.setOrderState(OrderState.CANCEL);
		orderRepository.save(order);

	}

	@Override
	public void acceptOrder(int idOrder) {
		Order order = orderRepository.findById(idOrder).get();
		order.setOrderState(OrderState.INPROGRESS);
		orderRepository.save(order);

	}

	@Override
	public void orderDone(int idOrder) {
		Order order = orderRepository.findById(idOrder).get();
		order.setOrderState(OrderState.DELIVRED);
		orderRepository.save(order);

	}

	@Override
	public void orderPayed(int idOrder) {
		Order order = orderRepository.findById(idOrder).get();
		order.setOrderState(OrderState.PAYED);
		orderRepository.save(order);

	}

}
