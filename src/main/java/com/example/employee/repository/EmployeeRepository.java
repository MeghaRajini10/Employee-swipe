package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Employee;

<<<<<<< HEAD
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
=======
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findEmployeeByempemail(String empemail);
>>>>>>> 377078e53ca8bdd4a98d6b84a83318911bb9f981

	Employee findByemail(String empemail);

}
