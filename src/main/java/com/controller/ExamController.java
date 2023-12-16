package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ExamBean;
import com.dao.ExamDao;

import util.CustomeResponse;

@RestController
@RequestMapping("/api")
public class ExamController {

	@Autowired
	ExamDao examDao;

	
	@GetMapping("/exams")
	public ResponseEntity<?>getAllExams(){
		
		
		CustomeResponse customeResponse = new CustomeResponse();
		List<ExamBean> exams = examDao.getAllExams();
		if(exams.size()>0) {
			
			customeResponse.setCode(HttpStatus.OK);
			customeResponse.setData(exams);
			customeResponse.setMessage("exam Fetched Successfully..");
			return new ResponseEntity<>(customeResponse, HttpStatus.OK);
		}
		else {
		
			customeResponse.setCode(HttpStatus.EXPECTATION_FAILED);
			customeResponse.setData(null);
			customeResponse.setMessage("error while fetching exam");
			return new ResponseEntity<>(customeResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	@PostMapping("/createexam")
	public ResponseEntity<?> createExam(@RequestBody ExamBean examBean) {

		CustomeResponse customeResponse = new CustomeResponse();
		int res = examDao.addExam(examBean);

		if (res > 0) {

			customeResponse.setCode(HttpStatus.CREATED);
			customeResponse.setData(examBean);
			customeResponse.setMessage("exam Created Successfully..");
			return new ResponseEntity<>(customeResponse, HttpStatus.CREATED);
		} else {

			customeResponse.setCode(HttpStatus.EXPECTATION_FAILED);
			customeResponse.setData(null);
			customeResponse.setMessage("exam Creation Failed..");
			return new ResponseEntity<>(customeResponse, HttpStatus.EXPECTATION_FAILED);

		}

	}

}
