package com.ausecourse.dao;

import java.util.List;

import com.ausecourse.model.Order;
import com.ausecourse.model.User;

public interface IOrderDAO {

	Order getById(int id);

	void update(Order order);

	void delete(int id);

	void push(Order order);
	
	/*
	 * retourne tous les livreurs pouvant effectuer cette commande.
	 */
	List<User> listDeliverd(String idClient, int idOrder); // retourne une listes de livreur pouvant la livrer. 
	
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
