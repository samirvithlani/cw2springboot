package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.EmployeeBean;
import com.dao.EmployeeDao;

import util.CustomeResponse;

@RestController
@RequestMapping(value = "/api")
//localhost:8080/api/employee
public class EmployeeController1 {

	@Autowired
	EmployeeDao employeeDao;

	@GetMapping(value = "/employee")
	public ResponseEntity<List<EmployeeBean>> getAllEmployees() {

		List<EmployeeBean> employees = employeeDao.getAllEmployees();
		if (employees.size() > 0) {

			return new ResponseEntity<List<EmployeeBean>>(employees, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<List<EmployeeBean>>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "/employee1")
	public ResponseEntity<CustomeResponse> getAllEmployees1() {

		List<EmployeeBean> employees = employeeDao.getAllEmployees();
		CustomeResponse customeResponse = new CustomeResponse();
		if (employees.size() > 0) {

			customeResponse.setCode(HttpStatus.OK);
			customeResponse.setData(employees);
			customeResponse.setMessage("employee fetched successfull");
			return new ResponseEntity<CustomeResponse>(customeResponse, HttpStatus.OK);

		} else {
			customeResponse.setCode(HttpStatus.EXPECTATION_FAILED);
			customeResponse.setData(null);
			customeResponse.setMessage("error in fetching employee");
			return new ResponseEntity<CustomeResponse>(customeResponse, HttpStatus.EXPECTATION_FAILED);
		}

	}

}
