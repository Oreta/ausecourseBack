package com.ausecourse.controller;

import java.util.HashMap;
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
/* dans un cas classique, ordre des principaux  ctrl a appelée:
 * createOrder
 * deliverer
 * deliveredChoice
 * acceptOrder
 * orderDone
 * orderPayed
 */
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

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity update(@RequestBody Order order) throws Exception {

		try {
			orderDao.push(order);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return new ResponseEntity("uptdate faill", HttpStatus.NOT_ACCEPTABLE);
		}

		return new ResponseEntity("uptdate Success", HttpStatus.OK);

	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	public Order getById(@RequestBody int id) throws Exception {
		Order order = null;
		try {
			order = orderDao.getById(id);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return null;
		}

		return order;

	}

	@RequestMapping(value = "/getAllByIdClient", method = RequestMethod.GET)
	public List<Order> getAllByIdClient(@RequestBody String idClient) {
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

	@RequestMapping(value = "/deliverer", method = RequestMethod.GET)
	public List<User> deliverer(@RequestBody HashMap<String, String> params) throws Exception {
		String idClient= params.get("idClient"); // mail
		int idOrder= Integer.parseInt(params.get("idOrder"));
		List<User> users = null;
		
		try {
			users = orderDao.deliverer(idClient, idOrder);
		} catch (Exception e) {
			System.err.println(e.getMessage()+" "+e.getCause());

		}

		return users;

	}
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public int createOrder(@RequestBody String idClient) throws Exception {
		int idOrder = 0;

		try {
			idOrder = orderDao.createOrder(idClient);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());

		}

		return idOrder;

	}

	@RequestMapping(value = "/deliveredChoice", method = RequestMethod.PUT)
	public ResponseEntity deliveredChoice(@RequestBody String idLivreur, int idOrder) throws Exception {
		List<User> users = null;

		try {
			orderDao.deliveredChoice(idOrder, idLivreur);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return new ResponseEntity("delete faill", HttpStatus.NOT_ACCEPTABLE);

		}

		return new ResponseEntity("livreur choosed  Success", HttpStatus.OK);

	}

	@RequestMapping(value = "/acceptOrder", method = RequestMethod.PUT)
	public ResponseEntity acceptOrder(@RequestBody int idOrder) throws Exception {
		List<User> users = null;

		try {
			orderDao.acceptOrder(idOrder);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return new ResponseEntity("acceptOrder faill", HttpStatus.NOT_ACCEPTABLE);

		}

		return new ResponseEntity("acceptOrder Success", HttpStatus.OK);

	}

	@RequestMapping(value = "/orderDone", method = RequestMethod.PUT)
	public ResponseEntity orderDone(@RequestBody int idOrder) throws Exception {
		List<User> users = null;

		try {
			orderDao.orderDone(idOrder);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return new ResponseEntity("orderDone faill", HttpStatus.NOT_ACCEPTABLE);

		}

		return new ResponseEntity("orderDone Success", HttpStatus.OK);

	}

	@RequestMapping(value = "/cancelOrder", method = RequestMethod.PUT)
	public ResponseEntity cancelOrder(@RequestBody int idOrder) throws Exception {
		List<User> users = null;

		try {
			orderDao.cancelOrder(idOrder);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return new ResponseEntity("cancelOrder faill", HttpStatus.NOT_ACCEPTABLE);

		}

		return new ResponseEntity("cancelOrder Success", HttpStatus.OK);

	}

	@RequestMapping(value = "/orderPayed", method = RequestMethod.PUT)
	public ResponseEntity orderPayed(@RequestBody int idOrder) throws Exception {
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