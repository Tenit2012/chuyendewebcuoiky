package com.nlu.cdw.ten.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserInterfaces extends JpaRepository<Users, Long> {
	
	@Query("select u from Users u where u.old = :old")
	Users getByOld(@Param("old") int old);

}
