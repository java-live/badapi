package com.student.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.beans.Student;
import com.student.beans.StudentRegistrationReply;
import com.student.beans.StudentRepository;

@Controller
public class StudentRegistrationController {

	@RequestMapping(method = RequestMethod.POST, value = "/register/student")

	@ResponseBody
	StudentRegistrationReply registerStudent(@RequestBody Student student) {
		System.out.println(" request for student registration: " + student);

		StudentRegistrationReply stdregreply = new StudentRegistrationReply();
		student.setPgp(StudentRepository.getInstance().generatePGP());
		StudentRepository.getInstance().add(student);

		// We are setting the below value just to reply a message back to the caller
		stdregreply.setName(student.getName());
		stdregreply.setAge(student.getAge());
		stdregreply.setRegistrationNumber(student.getRegistrationNumber().toString());
		stdregreply.setRegistrationStatus("Successful");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		stdregreply.setRegistrationDate(df.format(new Date()));
		System.out.println(" reply for student registration: " + stdregreply);

		return stdregreply;

	}

}
