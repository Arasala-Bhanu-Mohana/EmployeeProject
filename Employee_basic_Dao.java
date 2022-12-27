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

import com.employee.models.Employee_basic;

@Component
public class Employee_basic_Dao {
	
	@Autowired
	JdbcTemplate template;

	public boolean savedetailstoemp(Employee_basic emp) {
		// TODO Auto-generated method stub
		boolean status = false;

		String sql = "insert into employee_management.details(id,emp_id,first_name,last_name,date_of_birth,contact_info,address,qualification,current_experience,start_year,end_year,designation,gender,marital_status) "

					+ "values("
					+emp.getId()+","
					+emp.getEmp_id()+","
					+"'"+emp.getFirst_name()+"',"
					+"'"+emp.getLast_name()+"'"
					+","+emp.getDate_of_birth()+","
					+emp.getContact_info()+" ,"
					+"'"+emp.getAddress()+"'"
					+",'"+emp.getQualification()+"'"
					+","+emp.getCurrent_experience()+","
					+emp.getStart_year()+","
					+emp.getEnd_year()+","
					+"'"+emp.getDesignation()+"',"
					+"'"+emp.getGender()+"',"
					+"'"+emp.getMarital_status()+"'"
					+")";
		try {
			template.execute(sql);
			status = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Employee_basic> getEmployeeData() {
		List<Employee_basic> empList = new ArrayList<>();
		return template.query("select * from employee_management.details", new ResultSetExtractor<List<Employee_basic>>() {

			@Override
			public List<Employee_basic> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					Employee_basic emp = new Employee_basic();
					emp.setEmp_id(rs.getInt("emp_id"));
					emp.setFirst_name(rs.getString("first_name"));
					emp.setLast_name(rs.getNString("last_name"));
					emp.setDate_of_birth(rs.getInt("date_of_birth"));
					emp.setContact_info(rs.getLong("contact_info"));
					emp.setAddress(rs.getString("address"));
					emp.setQualification(rs.getString("qualification"));
					emp.setCurrent_experience(rs.getFloat("current_experience"));
					emp.setStart_year(rs.getLong("start_year"));
					emp.setEnd_year(rs.getLong("end_year"));
					emp.setDesignation(rs.getString("designation"));
					emp.setGender(rs.getString("gender"));
					emp.setMarital_status(rs.getString("marital_status"));
					empList.add(emp);				}
				return empList;
			}
			
		});
	}

}
