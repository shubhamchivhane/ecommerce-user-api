package com.ecom.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.api.model.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

	Integer countByuserName(String name);
	
}
