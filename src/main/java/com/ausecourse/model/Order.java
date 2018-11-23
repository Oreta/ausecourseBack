package com.ausecourse.model;

public class Order {
	
	int clientID;
	int livreurId;
	int listeCourseId;
	boolean paymentCommande;
	OrderState orderState;
	
	public Order(int clientID, int livreurId, int listeCourseId, boolean paymentCommande, OrderState orderState) {
		super();
		this.clientID = clientID;
		this.livreurId = livreurId;
		this.listeCourseId = listeCourseId;
		this.paymentCommande = paymentCommande;
		this.orderState = orderState;
	}
	@Override
	public String toString() {
		return "Order [clientID=" + clientID + ", livreurId=" + livreurId + ", listeCourseId=" + listeCourseId
				+ ", paymentCommande=" + paymentCommande + ", commandeState=" + orderState + "]";
	}

	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public int getLivreurId() {
		return livreurId;
	}
	public void setLivreurId(int livreurId) {
		this.livreurId = livreurId;
	}
	public int getListeCourseId() {
		return listeCourseId;
	}
	public void setListeCourseId(int listeCourseId) {
		this.listeCourseId = listeCourseId;
	}
	public boolean isPaymentCommande() {
		return paymentCommande;
	}
	public void setPaymentCommande(boolean paymentCommande) {
		this.paymentCommande = paymentCommande;
	}
	public OrderState getOrderState() {
		return orderState;
	}
	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

}
