package com.tmeal.member;

import java.sql.Timestamp;

public class tmmemberbean {

	private String id;
	private String pw;
	private String name;
	private String gender;
	private String birth;
	private int phoneNumber;
	private String email;
	private String address;
	private String knowpath;
	private Timestamp regdate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getKnowpath() {
		return knowpath;
	}
	public void setKnowpath(String knowpath) {
		this.knowpath = knowpath;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "tmmemberbean [id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender + ", birth=" + birth
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + ", knowpath="
				+ knowpath + ", regdate=" + regdate + "]";
	}
	
	

	
	
}
