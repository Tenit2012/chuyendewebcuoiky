package com.nlu.cdw.ten.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mng_users")
public class Users {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int old;
	
	
	public Users() {
	}
	public Users(long id, String name, int old) {
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
