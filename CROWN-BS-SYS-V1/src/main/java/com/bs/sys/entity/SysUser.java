package com.bs.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 177030063138338860L;
	
	private Integer id;
	private String user;
	private String email;
	private String phone;
	private String password;
	private String salt;
	private String regi_time;
	private String lin_time;
	private String lout_time;
	private String birthday;
	private String sign_self;
	private String photo;
	private String gender;
	private String update_password;
	private String zt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getRegi_time() {
		return regi_time;
	}
	public void setRegi_time(String regi_time) {
		this.regi_time = regi_time;
	}
	public String getLin_time() {
		return lin_time;
	}
	public void setLin_time(String lin_time) {
		this.lin_time = lin_time;
	}
	public String getLout_time() {
		return lout_time;
	}
	public void setLout_time(String lout_time) {
		this.lout_time = lout_time;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSign_self() {
		return sign_self;
	}
	public void setSign_self(String sign_self) {
		this.sign_self = sign_self;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getUpdate_password() {
		return update_password;
	}
	public void setUpdate_password(String update_password) {
		this.update_password = update_password;
	}
	
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
