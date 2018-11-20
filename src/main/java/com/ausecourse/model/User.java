package com.ausecourse.model;

import java.io.Serializable;



import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ausecourse.dao.UserSecurityDao;
import com.ausecourse.model.security.Authority;
import com.ausecourse.model.security.UserRole;

import jdk.internal.jline.internal.Log;
import lombok.EqualsAndHashCode;


@RedisHash("User")
@EqualsAndHashCode(exclude = { "userRoles" })
public class User implements UserDetails,Serializable {
	
	private static final Logger LOG = LoggerFactory.getLogger(User.class);
	
	@Id
	@EqualsAndHashCode.Exclude private String id;
	@EqualsAndHashCode.Exclude private String name;
	@Indexed private String username;
	private String password; 

	private String email;
	@EqualsAndHashCode.Exclude private int tel;
	@EqualsAndHashCode.Exclude private int numeroRoad;
	@EqualsAndHashCode.Exclude private String Road;
	@EqualsAndHashCode.Exclude private String city;
	@EqualsAndHashCode.Exclude private String country; // tout en maj
	
	private @Reference Set<UserRole> userRoles = new HashSet<UserRole>();
	
	public User() {
		super();
	}
	
	public User(String id) {
		super();
		this.id = id;
	}
	
	public User(String id, String name) {
		super();
		this.id = id;
		this.name=name;
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
		return username;
	}

	public void setNickname(String nickname) {
		this.username = nickname;
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

	
	
	public void setUsername(String username) {
		this.username = username;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public User(String id, String name, String nickname, String email, int tel, int numeroRoad, String road, String city,
			String country) {
		super();
		this.id = id;
		this.name = name;
		this.username = nickname;
		this.email = email;
		this.tel = tel;
		this.numeroRoad = numeroRoad;
		Road = road;
		this.city = city;
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", nickname=" + username + ", email=" + email + ", tel=" + tel
				+ ", numeroRoad=" + numeroRoad + ", Road=" + Road + ", city=" + city + ", country=" + country + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for(UserRole ur : this.userRoles) { 
			authorities.add(new Authority(ur.getRole().getName()));
			Log.warn("user authorities {}" , ur.getRole().getName());
		}
		return authorities;
	}
	

	
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password ;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	
	
	
	
	
	
	
	

}
