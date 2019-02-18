package com.bs.sys.entity;

import java.io.Serializable;

public class SysSpot implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8690790335735323800L;
	private Integer id;
	private String jdname;
	private String city_id;
	private String imgname;
	private String nr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJdname() {
		return jdname;
	}
	public void setJdname(String jdname) {
		this.jdname = jdname;
	}
	public String getCity_id() {
		return city_id;
	}
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
