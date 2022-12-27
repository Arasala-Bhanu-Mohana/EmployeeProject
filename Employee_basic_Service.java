package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.Employee_basic_Dao;
import com.employee.models.Employee_basic;


@Service
public class Employee_basic_Service {

	@Autowired
	Employee_basic_Dao employee_basic_dao;
	
	public List<Employee_basic> getUserDetailsFromDb(){
		List<Employee_basic> empList = employee_basic_dao.getEmployeeData();
		return empList;
		
	}
	
	public boolean postdata(Employee_basic emp) {
		return employee_basic_dao.savedetailstoemp(emp);
	}

}

//@Service
//public class EmployeeService {
//	@Autowired
//	EmployeeDao employeeDao;
//
//	public void createEmployeeDataInEmployeeDao(Employee employee) {
//		employeeDao.createEmployeeInDb(employee);
//	}
//	
//	public List<Employee> getAllEmployeeFromEmployeeDao(){
//		return employeeDao.getAllEmployeeFromDb();
//	}
//	
//	public Employee getEmployeeDataFromEmployeeDao(int id){
//		return employeeDao.getEmployeeDetailsFromDb(id);
//	}
//	
//	public void updateEmployeeDataFromEmployeeDao(Employee employee){
//		employeeDao.updateEmployeeInDb(employee);
//	}
//	
//	public void deleteEmployeeDataFromEmployeeDao(int id){
//		employeeDao.deleteEmployeeInDb(id);
//	}
