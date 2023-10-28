package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

//	@GetMapping("/employee")
//	public List<EmployeeBean> getAllEmployees() {
//
//		return employeeList;
//	}

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

	@PutMapping(value = "/updateemployee/{id}")
	public String updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeBean employeeBean) {
		int res = employeeDao.updateEmployee(id, employeeBean);
		if (res > 0) {

			return "employee updated...";
		}
		return "employee not updated..";

	}

	@DeleteMapping(value = "/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {

		int res = employeeDao.deleteEmployee(id);
		if (res > 0) {

			return "employee deleted";
		}
		return "employee not deleted";
	}

	@GetMapping(value = "/employees")
	public List<EmployeeBean> getAllEmployees() {

		List<EmployeeBean> employees = employeeDao.getAllEmployees();

		return employees;

	}

	@GetMapping(value = "/employee/{id}")
	public EmployeeBean getEmpById(@PathVariable("id") int id) {

		EmployeeBean employeeBean = employeeDao.getEMployeeById(id);
		if (employeeBean != null) {
			System.out.println("..");
			return employeeBean;
		}
		return null;

	}

}
