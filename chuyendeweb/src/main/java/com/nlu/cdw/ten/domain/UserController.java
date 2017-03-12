package com.nlu.cdw.ten.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	@RequestMapping(method = RequestMethod.GET,value = "/getall")
	public List<Users> getAll(){
		return userService.getAll();
	}
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public void insert(@RequestBody Users user){
		userService.insert(user);
	}
	@RequestMapping(method = RequestMethod.GET,value = "/getbyold/{old}")
	public Users getByOld(@PathVariable int old){
		return userService.getByOld(old);
	}

}
