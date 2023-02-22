package com.example.employee.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class SwipeData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long swipeid;
	private String empname;
	
	private long empid;
	private LocalDateTime swipeintime;
	private LocalDateTime swipeouttime;
	private LocalDate date;
	private String status;;
	public long getSwipeid() {
		return swipeid;
	}
	public void setSwipeid(long swipeid) {
		this.swipeid = swipeid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	public LocalDateTime getSwipeintime() {
		return swipeintime;
	}
	public void setSwipeintime(LocalDateTime swipeintime) {
		this.swipeintime = swipeintime;
	}
	public LocalDateTime getSwipeouttime() {
		return swipeouttime;
	}
	public void setSwipeouttime(LocalDateTime swipeouttime) {
		this.swipeouttime = swipeouttime;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
	
	

}
