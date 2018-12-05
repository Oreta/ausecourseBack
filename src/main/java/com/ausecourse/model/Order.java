package com.ausecourse.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
@RedisHash("Order")
public class Order {
	@Id
	String clientID;
	String livreurId;
	List <Product> listProduct;

	OrderState orderState;
	
	public List<Product> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}


	@Override
	public String toString() {
		return "Order [clientID=" + clientID + ", livreurId=" + livreurId + ", listProduct=" + listProduct
				+ ", orderState=" + orderState + "]";
	}
	public Order(String clientID, String livreurId, List<Product> listProduct, OrderState orderState) {
		super();
		this.clientID = clientID;
		this.livreurId = livreurId;
		this.listProduct = listProduct;
		this.orderState = orderState;
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

	public OrderState getOrderState() {
		return orderState;
	}
	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

}
