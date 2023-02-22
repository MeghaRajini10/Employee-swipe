package com.example.employee.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class TempSwipeData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tempswipeid;
	private LocalDateTime tempswipedin;
	private LocalDateTime tempswipedout;
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
