package com.ausecourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ausecourse.dao.IOrderDAO;
import com.ausecourse.dao.IUserDao;
import com.ausecourse.model.Order;
import com.ausecourse.model.User;

@RestController
@RequestMapping("/order")
public class OrderController {
//routes

	@Autowired
	private IUserDao userDao;
	@Autowired
	private IOrderDAO orderDao;

//	@RequestMapping(value = "/push", method = RequestMethod.POST)
//	public ResponseEntity push(@RequestBody Order order) throws Exception {
//
//		try {
//			orderDao.push(order);
//		} catch (Exception e) {
//			System.err.println(e.getStackTrace());
//			return new ResponseEntity("push faill", HttpStatus.NOT_ACCEPTABLE);
//		}
//
//		return new ResponseEntity("push Success", HttpStatus.OK);
//
//	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity update(@RequestBody Order order) throws Exception {

		try {
			orderDao.push(order);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return new ResponseEntity("uptdate faill", HttpStatus.NOT_ACCEPTABLE);
		}

		return new ResponseEntity("uptdate Success", HttpStatus.OK);

	}

	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public Order getById(int id) throws Exception {
		Order order = null;
		try {
			order = orderDao.getById(id);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return null;
		}

		return order;

	}

	@RequestMapping(value = "/getAllByIdClient", method = RequestMethod.POST)
	public List<Order> getAllByIdClient(String idClient) {
		List<Order> order = null;
		try {
			order = orderDao.getAllOrderByIdClient(idClient);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return null;
		}

		return order;

	}

//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public ResponseEntity delete(int id) throws Exception {
//
//		try {
//			orderDao.delete(id);
//		} catch (Exception e) {
//			System.err.println(e.getStackTrace());
//			return new ResponseEntity("delete faill", HttpStatus.NOT_ACCEPTABLE);
//		}
//
//		return new ResponseEntity("delete Success", HttpStatus.OK);
//
//	}

	@RequestMapping(value = "/deliverer", method = RequestMethod.POST)
	public List<User> deliverer(String idClient, int idOrder) throws Exception {
		List<User> users = null;

		try {
			users = orderDao.deliverer(idClient, idOrder);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());

		}

		return users;

	}

	@RequestMapping(value = "/deliveredChoice", method = RequestMethod.POST)
	public ResponseEntity deliveredChoice(String idLivreur, int idOrder) throws Exception {
		List<User> users = null;

		try {
			orderDao.deliveredChoice(idOrder, idLivreur);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return new ResponseEntity("delete faill", HttpStatus.NOT_ACCEPTABLE);

		}

		return new ResponseEntity("livreur choosed  Success", HttpStatus.OK);

	}

	@RequestMapping(value = "/acceptOrder", method = RequestMethod.POST)
	public ResponseEntity acceptOrder(int idOrder) throws Exception {
		List<User> users = null;

		try {
			orderDao.acceptOrder(idOrder);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return new ResponseEntity("acceptOrder faill", HttpStatus.NOT_ACCEPTABLE);

		}

		return new ResponseEntity("acceptOrder Success", HttpStatus.OK);

	}

	@RequestMapping(value = "/orderDone", method = RequestMethod.POST)
	public ResponseEntity orderDone(int idOrder) throws Exception {
		List<User> users = null;

		try {
			orderDao.orderDone(idOrder);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return new ResponseEntity("orderDone faill", HttpStatus.NOT_ACCEPTABLE);

		}

		return new ResponseEntity("orderDone Success", HttpStatus.OK);

	}

	@RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
	public ResponseEntity cancelOrder(int idOrder) throws Exception {
		List<User> users = null;

		try {
			orderDao.cancelOrder(idOrder);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return new ResponseEntity("cancelOrder faill", HttpStatus.NOT_ACCEPTABLE);

		}

		return new ResponseEntity("cancelOrder Success", HttpStatus.OK);

	}

	@RequestMapping(value = "/orderPayed", method = RequestMethod.POST)
	public ResponseEntity orderPayed(int idOrder) throws Exception {
		List<User> users = null;

		try {
			orderDao.orderPayed(idOrder);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return new ResponseEntity("orderPayed faill", HttpStatus.NOT_ACCEPTABLE);

		}

		return new ResponseEntity("orderPayed Success", HttpStatus.OK);

	}

}