package com.employee.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.models.Employee_basic;
import com.employee.service.Employee_basic_Service;

@RestController
public class Employee_basic_controllers {
		@Autowired
		Employee_basic_Service employee_basic_service;
		
		@RequestMapping(value ="/getempdata",method = RequestMethod.GET)
		public List<Employee_basic> getUserDetailsFromDao(){
			List<Employee_basic> empList = employee_basic_service.getUserDetailsFromDb();
			return empList;
			
		}
		
		@RequestMapping(value="/postempdata",method = RequestMethod.POST,
				consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
		public String postUserData(@RequestBody Employee_basic emp) {
	
			String statusMessage;
			if(0==emp.getId()) {
				throw new IllegalArgumentException("Id is not valid");
			}
			if(0==emp.getEmp_id()) {
				throw new IllegalArgumentException("Employee Id is not valid");
			}
			if(Objects.isNull(emp.getFirst_name()) && "".equals(emp.getFirst_name())) {
				throw new IllegalArgumentException("First Name is empty");
			}
			
			if(Objects.isNull(emp.getLast_name()) && " ".equals(emp.getLast_name())) {
				throw new IllegalArgumentException("Last name is empty");
			}
	
			boolean status = employee_basic_service.postdata(emp);
	
			if(status) {
				statusMessage = "Employee Added..";
			}else {
				statusMessage = "Failed....!";
			}
			return statusMessage;
		}
	

	}

