package com.student.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.beans.StudentRepository;

@Controller
public class StudentDeleteController {

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/student/{regdNum}")

	@ResponseBody
	public String deleteStudentRecord(@PathVariable("regdNum") Integer regdNum) {
		System.out.println("In deleteStudentRecord");
		return StudentRepository.getInstance().deleteStudent(regdNum);
	}

}
