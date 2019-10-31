/**
 * 
 */
package com.spartans.Starbucks.service;

/**
 * @author musahay
 *
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spartans.Starbucks.dao.CustomerDetails;

public class UserRowMapper implements RowMapper<CustomerDetails> {

	@Override
	public CustomerDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(rowNum + " test test test test");
		CustomerDetails user = new CustomerDetails();
		user.setEmail(rs.getString("Email"));
		user.setPassword(rs.getString("Password"));
		user.setFirst_name(rs.getString("First_Name"));
		user.setLast_name(rs.getString("Last_Name"));
		user.setCust_id(rs.getInt("cust_id"));
		user.setState(rs.getString("State"));
		user.setCity(rs.getString("City"));
		
		return user;
	}
}