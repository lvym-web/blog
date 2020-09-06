package com.lvym.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lvym.pojo.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsernameAndPassword(String username, String password);
}
