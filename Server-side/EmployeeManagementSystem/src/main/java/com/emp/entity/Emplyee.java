package com.emp.entity;

public class Emplyee {
	
	private Integer id;
	private String ename;
	private String eposition;
	private String email;
	private Integer salary;
	
	public Emplyee() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEposition() {
		return eposition;
	}
	public void setEposition(String eposition) {
		this.eposition = eposition;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Emplyee [id=" + id + ", ename=" + ename + ", eposition=" + eposition + ", email=" + email + ", salary="
				+ salary + "]";
	}

}
