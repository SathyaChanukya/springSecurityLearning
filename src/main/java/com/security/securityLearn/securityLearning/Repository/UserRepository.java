package com.security.securityLearn.securityLearning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.securityLearn.securityLearning.Entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	User findByUsername(String username);
}

