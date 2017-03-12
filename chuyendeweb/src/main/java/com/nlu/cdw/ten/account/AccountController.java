package com.nlu.cdw.ten.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(method = RequestMethod.GET,value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {
	@Autowired
	UserServices userService;
	@RequestMapping(method = RequestMethod.GET,value = "/getall")
	public @ResponseBody List<Account> getAll(){
		return userService.getAll();
	}
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public @ResponseBody void insert(@RequestBody Account user){
		userService.insert(user);
	}

}
