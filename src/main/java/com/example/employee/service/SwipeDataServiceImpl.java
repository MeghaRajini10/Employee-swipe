package com.example.employee.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.entity.SwipeData;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.SwipeDataRepository;
@Service
public class SwipeDataServiceImpl implements SwipeDataService{
	@Autowired
	SwipeDataRepository swipeDataRepository;
	
	

	@Override
	public List<SwipeData> search(long empid){
		
		return swipeDataRepository.findByEmpid(empid);
	}

//	@Override
//	public String getAll(SwipeData swipeData,long empid) {
//		List<Employee> empList=new ArrayList();
//		Iterator itr=empList.iterator();
//		while(itr.hasNext()) {
//			Employee emp=(Employee)itr.next();
//			if(emp.getRole()=="Admin") {
//				return employeeRepository.findAllByRole();
//			}
//			
//		}
//		return "The given Employee is not an Admin";
//	
//	}

}
