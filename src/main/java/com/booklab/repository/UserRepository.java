package com.booklab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.booklab.model.Registration;
@Repository
public interface UserRepository extends JpaRepository<Registration, Integer> {
    @Query("select u from Registration u where u.email=:email")
	public Registration getUserByUserName(@Param("email") String email);
    
    
	
}
