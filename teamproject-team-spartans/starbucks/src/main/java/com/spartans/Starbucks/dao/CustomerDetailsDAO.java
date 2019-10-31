/**
 * 
 */
package com.spartans.Starbucks.dao;

/**
 * @author musahay
 *
 */

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDetailsDAO extends CrudRepository<CustomerDetails,Integer> {

	List<CustomerDetails> findAll();
	 
    //Optional<CustomerDetails> findById(Integer cust_id);	
}