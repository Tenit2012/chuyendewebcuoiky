package com.nlu.cdw.ten.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

		@Autowired
		UserInterface userInterface;
		
		public List<Account> getAll(){
			return userInterface.findAll();
		}
		public void insert(Account user){
			userInterface.save(user);
		}
}
