/**
 * 
 */
package com.swt.meetingregister;

import java.util.List;

import com.swt.meetingregister.doman.Account;

/**
 * @author Tenit
 *
 */
public interface RegisterAccount {
	public Account login(String userName, String passWord);
	public Account insert(Account account);
	public Account update(Account account);
	public int delete(long accountId);
	public List<Account> getListAccount();

}
