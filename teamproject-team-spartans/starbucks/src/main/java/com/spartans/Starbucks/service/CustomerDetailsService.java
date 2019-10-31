/**
 * 
 */
package com.spartans.Starbucks.service;

/**
 * @author musahay
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.spartans.Starbucks.dao.CustomerDetails;
import com.spartans.Starbucks.dao.CustomerDetailsDAO;

@Service
public class CustomerDetailsService {

	@Autowired
	private CustomerDetailsDAO customerdetailsDAO;
	
	@Autowired 
	JdbcTemplate jdbcTemplate;

	
	public List<CustomerDetails> getAllCustomers() {
		
		List<CustomerDetails> customerDetails = new ArrayList<>();
		customerdetailsDAO.findAll().forEach(customerDetails::add);
		return customerDetails;
		
	}
	
	
	public CustomerDetails getCustomerDetails(int cust_id) {
		
		System.out.println("Cust Id" + cust_id);

		return customerdetailsDAO.findById(cust_id).orElse(null);
		
	}
	

	public void addCustomerDetails(CustomerDetails custdetails) {
		customerdetailsDAO.save(custdetails);
	}
	
	
public void updateUser(CustomerDetails userDetails) {
		
		Date date = new Date();
		Time t = new java.sql.Time(date.getTime());
		
		Connection connection = null;
		System.out.println("Add User Update Control" + userDetails.getCust_id());
		System.out.println(userDetails.getFirst_name());
		System.out.println(userDetails.getLast_name());
		
		String UPDT_SQL = "UPDATE CUST_DETAILS SET FIRST_NAME = ?, LAST_NAME = ?,  CITY = ?, STATE = ? where CUST_ID=?";
		
		
		try{
		connection = jdbcTemplate.getDataSource().getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement(UPDT_SQL);
		preparedstatement.setString(1, userDetails.getFirst_name());
		preparedstatement.setString(2, userDetails.getLast_name());
		preparedstatement.setString(3, userDetails.getCity());
		preparedstatement.setString(4, userDetails.getState());
		preparedstatement.setInt(5, userDetails.getCust_id());
		
		preparedstatement.executeUpdate();
		preparedstatement.close();
		}catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                	connection.close();
                } catch (SQLException e) {}

            }
        }
}
}
