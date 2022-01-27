package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	public User findByUserEmailAndUserPassword(String email,String pw);
	@Query("select u from User u where u.userEmail = :email")
	public User getByUserName(@Param("email") String email);
}
