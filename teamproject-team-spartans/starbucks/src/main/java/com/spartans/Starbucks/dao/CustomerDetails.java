/**
 * 
 */
package com.spartans.Starbucks.dao;

/**
 * @author musahay
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUST_DETAILS")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUST_ID")
	int cust_id;
	
	@Column(name = "FIRST_NAME")
	String first_name;

	
	@Column(name = "LAST_NAME")
	String last_name;
	
	@Column(name = "EMAIL")
	String email;
	
	
	@Column(name = "CITY")
	String city;
	
	@Column(name = "STATE")
	String state;
	
	@Column(name = "PASSWORD")
	String password;

	public CustomerDetails(String first_name, String last_name, String email, String city,
			String state) {
		super();
		this.first_name = first_name;
		
		this.last_name = last_name;
		this.email = email;
		this.city = city;
		this.state = state;
	}
	
	public CustomerDetails() {
		super();
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}