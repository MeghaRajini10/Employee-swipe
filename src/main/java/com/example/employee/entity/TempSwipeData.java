package com.example.employee.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
@Entity
public class TempSwipeData {
	private long tempswipeid;
	LocalDateTime tempswipedin;
	LocalDateTime tempswipedout;
	private long empid;
	public long getTempswipeid() {
		return tempswipeid;
	}
	public void setTempswipeid(long tempswipeid) {
		this.tempswipeid = tempswipeid;
	}
	public LocalDateTime getTempswipedin() {
		return tempswipedin;
	}
	public void setTempswipedin(LocalDateTime tempswipedin) {
		this.tempswipedin = tempswipedin;
	}
	public LocalDateTime getTempswipedout() {
		return tempswipedout;
	}
	public void setTempswipedout(LocalDateTime tempswipedout) {
		this.tempswipedout = tempswipedout;
	}
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	
	
	
	
	

}
