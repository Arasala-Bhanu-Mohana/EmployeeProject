package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.models.Holiday_info;
import com.employee.service.Holiday_info_Service;

@RestController
public class Holiday_info_controller {
	
	@Autowired
	Holiday_info_Service holiday_info_service;
	
	@RequestMapping(value ="/getholidaydetails",method = RequestMethod.GET)
	public List<Holiday_info> getUserDetailsFromDao(){
		List<Holiday_info> holidayDetails = holiday_info_service.getHolidayDetails();
		return holidayDetails;
		
	}

}
