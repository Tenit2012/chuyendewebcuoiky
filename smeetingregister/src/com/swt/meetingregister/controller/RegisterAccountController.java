/**
 * 
 */
package com.swt.meetingregister.controller;

import java.util.List;

import com.swt.meetingregister.RegisterAccount;
import com.swt.meetingregister.RegisterAccountImpl;
import com.swt.meetingregister.doman.Account;

/**
 * @author Tenit
 *
 */
public class RegisterAccountController {
	
	public static final RegisterAccountController Instance = new RegisterAccountController();
	RegisterAccount registerAccount = new RegisterAccountImpl();
	public Account login(String userName, String passWord){
		return registerAccount.login(userName, passWord);
	}
	
	public Account insert(Account account){
		return registerAccount.insert(account);
	}
	
	public Account update(Account account){
		return registerAccount.update(account);
	}
	
	public int delete(long accountId){
		return registerAccount.delete(accountId);
	}
	
	public List<Account> getListAccount(){
		return registerAccount.getListAccount();
	}
}
