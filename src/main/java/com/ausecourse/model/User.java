package com.ausecourse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("User")
public class User {
	@Id
	private String id;
	private String name;
	private String nickname;
	private String email;
	private int tel;
	private int numeroRoad;
	private String Road;
	private String city;
	private String country; // tout en maj
	private boolean emailValide;
	public boolean isEmailValide() {
		return emailValide;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getNumeroRoad() {
		return numeroRoad;
	}
	public void setNumeroRoad(int numeroRoad) {
		this.numeroRoad = numeroRoad;
	}
	public String getRoad() {
		return Road;
	}
	public void setRoad(String road) {
		Road = road;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setEmailValide(boolean emailValide) {
		this.emailValide = emailValide;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", nickname=" + nickname + ", email=" + email + ", tel=" + tel
				+ ", numeroRoad=" + numeroRoad + ", Road=" + Road + ", city=" + city + ", country=" + country
				+ ", emailValide=" + emailValide + "]";
	}
	public User() {
		super();
	}
	public User(String id, String name, String nickname, String email, int tel, int numeroRoad, String road,
			String city, String country, boolean emailValide) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.tel = tel;
		this.numeroRoad = numeroRoad;
		Road = road;
		this.city = city;
		this.country = country;
		this.emailValide = emailValide;
	}
	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}