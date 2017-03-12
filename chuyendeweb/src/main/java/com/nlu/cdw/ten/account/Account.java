package com.nlu.cdw.ten.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "com_nlu_cdw_account")
public class Account {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int old;
	
	
	public Account() {
	}
	public Account(long id, String name, int old) {
		this.id = id;
		this.name = name;
		this.old = old;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
	}

}
