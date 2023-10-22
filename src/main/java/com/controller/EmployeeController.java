package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.EmployeeBean;
import com.dao.EmployeeDao;

@RestController
public class EmployeeController {

	public static List<EmployeeBean> employeeList = new ArrayList<>();

	@Autowired
	EmployeeDao employeeDao;

	@GetMapping("/employee")
	public List<EmployeeBean> getAllEmployees() {

		return employeeList;
	}

	@PostMapping("/employee")
	public String addEmployee(@RequestBody EmployeeBean employeeBean) {

		System.out.println(employeeBean);
		System.out.println(employeeBean.geteId());
		System.out.println(employeeBean.geteName());
		employeeList.add(employeeBean);
		return "employee added..";
	}

	@PostMapping("/addemp")
	public String addEmployee1(@RequestBody EmployeeBean employeeBean) {

		int res = employeeDao.addEmployee(employeeBean);
		if (res > 0) {
			return "employee addedd";

		}

		return "employee not addedd";

	}

}
