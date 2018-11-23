package com.ausecourse.model;

public class Order {
	
	String clientID;
	String livreurId;
	int listeCourseId;
	boolean paymentCommande;
	OrderState orderState;
	
	public Order(String clientID, String livreurId, int listeCourseId, boolean paymentCommande, OrderState orderState) {
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
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getLivreurId() {
		return livreurId;
	}
	public void setLivreurId(String livreurId) {
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
