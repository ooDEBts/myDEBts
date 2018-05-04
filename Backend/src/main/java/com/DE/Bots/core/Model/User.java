package com.DE.Bots.core.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User extends BaseModel {
	private String ids;
	private String name;
	private String contact;
	private String email;
	private long createdDate;
	private long lastLogged;
	private String password;
	private boolean isRobot;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}

	public long getLastLogged() {
		return lastLogged;
	}

	public void setLastLogged(long lastLogged) {
		this.lastLogged = lastLogged;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRobot() {
		return isRobot;
	}

	public void setRobot(boolean isRobot) {
		this.isRobot = isRobot;
	}

}
