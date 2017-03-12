package com.nlu.cdw.ten.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserInterfaces userInterfaces;
	
	public List<Users> getAll(){
		return userInterfaces.findAll();
	}
	public void insert(Users user){
		userInterfaces.save(user);
	}
	public Users getByOld(int old){
		return userInterfaces.getByOld(old);
	}

}
