package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.Holiday_info_Dao;
import com.employee.models.Holiday_info;

@Service
public class Holiday_info_Service {

	@Autowired
	Holiday_info_Dao holiday_info_dao;
	public List<Holiday_info> getHolidayDetails() {
		List<Holiday_info> holidayList = holiday_info_dao.getHolidayDetails();
		return holidayList;
	}

}
