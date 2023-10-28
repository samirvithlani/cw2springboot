package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.EmployeeBean;

@Repository
public class EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addEmployee(EmployeeBean employeeBean) {

		return jdbcTemplate.update("insert into employee (ename,eage,esalary)values(?,?,?)", employeeBean.geteName(),
				employeeBean.geteAge(), employeeBean.geteSalary());

	}

	public int updateEmployee(int eId, EmployeeBean employeeBean) {

		return jdbcTemplate.update("update employee set ename=?,eage=?,esalary=? where eid = ?",
				employeeBean.geteName(), employeeBean.geteAge(), employeeBean.geteSalary(), eId);
	}

	public int deleteEmployee(int eId) {

		return jdbcTemplate.update("delete from employee where eId = ?", eId);
	}

	private class EmployeeMapper implements RowMapper<EmployeeBean> {

		@Override
		public EmployeeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.seteId(rs.getInt("eId"));
			employeeBean.seteName(rs.getString("ename"));
			employeeBean.seteAge(rs.getInt("eAge"));
			employeeBean.seteSalary(rs.getDouble("eSalary"));
			return employeeBean;
		}

	}

	public List<EmployeeBean> getAllEmployees() {

		return jdbcTemplate.query("select * from employee", new EmployeeMapper());

	}

	public EmployeeBean getEMployeeById(int eId) {
		
		
		try {
			return jdbcTemplate.queryForObject("select * from employee where eid = "+eId+"", new EmployeeMapper());
		}
		catch (Exception e) {
			return null;
		}
	}
}
