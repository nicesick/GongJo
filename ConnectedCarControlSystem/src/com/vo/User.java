package com.vo;

import java.sql.Date;

public class User {
	String user_id;
	String user_pwd;
	String user_name;
	String user_gender;
	Date user_birthdate;
	String user_phone;
	String user_add;
	String user_email;
	String user_type;
	
	public User() {
		super();
	}

	public User(String user_id, String user_pwd, String user_name, String user_gender, Date user_birthdate,
			String user_phone, String user_add, String user_email, String user_type) {
		super();
		
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.user_gender = user_gender;
		this.user_birthdate = user_birthdate;
		this.user_phone = user_phone;
		this.user_add = user_add;
		this.user_email = user_email;
		this.user_type = user_type;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public Date getUser_birthdate() {
		return user_birthdate;
	}

	public void setUser_birthdate(Date user_birthdate) {
		this.user_birthdate = user_birthdate;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_add() {
		return user_add;
	}

	public void setUser_add(String user_add) {
		this.user_add = user_add;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_pwd=" + user_pwd + ", user_name=" + user_name + ", user_gender="
				+ user_gender + ", user_birthdate=" + user_birthdate + ", user_phone=" + user_phone + ", user_add="
				+ user_add + ", user_email=" + user_email + ", user_type=" + user_type + "]";
	}
}
