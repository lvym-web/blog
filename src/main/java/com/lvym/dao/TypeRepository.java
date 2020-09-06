package com.lvym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lvym.pojo.Type;

public interface TypeRepository extends JpaRepository<Type, Long>{



	
	Type findByName(String name);

	@Query("select t from Type t where id=:id ")
	Type findOne(Long id);

	

}
