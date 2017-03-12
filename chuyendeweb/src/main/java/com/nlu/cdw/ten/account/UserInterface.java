package com.nlu.cdw.ten.account;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserInterface extends JpaRepository<Account, Long> { 

}
