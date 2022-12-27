package com.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.employee.models.Holiday_info;
@Component
public class Holiday_info_Dao {
	
	@Autowired
	JdbcTemplate template;

	public List<Holiday_info> getHolidayDetails() {
		List<Holiday_info> holidayList = new ArrayList<>();
		return template.query("select * from employee_management.holiday_information;", new ResultSetExtractor<List<Holiday_info>>() {
			@Override
			public List<Holiday_info> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					Holiday_info info = new Holiday_info();
					info.setId(rs.getInt("id"));
					info.setEmp_id(rs.getInt("emp_id"));
					info.setNo_of_holidays(rs.getInt("no_of_holidays"));
				}
				return holidayList;
			}
			
		});
	}

}
