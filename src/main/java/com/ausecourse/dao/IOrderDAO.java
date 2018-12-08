package com.ausecourse.dao;

import java.util.List;

import com.ausecourse.model.ListeCourse;
import com.ausecourse.model.Order;
import com.ausecourse.model.User;

public interface IOrderDAO {
	
	Order getById(int id);
	List<Order> getAllOrderByIdClient(String idClient);

	void update(Order order);
	
	
	/* normalement a ne pas utilisée voir cancel */
	void delete(int id);
	/*
	 * pas sensée être utilisée
	 */
	void push(Order order);
	
	
	/*
	 * créer une commande 
	 */
	int createOrder(String idClient,ListeCourse listeCourse);
	
	/*
	 * retourne tous les livreurs pouvant effectuer cette commande.
	 */
	List<User> deliverer(String idClient, int idOrder); // retourne une listes de livreur pouvant la livrer. 
	
	/*
	 * permet d'indiqué quelle livreur à été choisit.
	 */
	void deliveredChoice(int idOrder, String idLiveur);
	
	void cancelOrder(int idOrder);
	
	/*
	 * étape de confirmation d'une commande de la part d'un client.
	 */
	
	void acceptOrder(int idCommande);
	
	void orderDone(int idCommande);
	
	/*
	 * Permet à un livreur d'inqiquer qu'une commande à été payée. 
	 */
	 
	void orderPayed(int idorder);
	
	 
	 
	
	
	
	

}
