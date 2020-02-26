package com.student.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.beans.Student;
import com.student.beans.StudentRepository;

@Controller
public class StudentCredentialsController {

	@RequestMapping(method = RequestMethod.GET, value = "/student/credentialgen")
	@ResponseBody
	public Map<String, String> getLogin(@RequestBody Student student) {

		// Map.of("login", StudentRepository.getInstance().buildLogin(student),
		// "password", "*********");

		Map<String, String> data = new HashMap<>();

		data.put("password", UUID.randomUUID().toString());
		data.put("login", StudentRepository.getInstance().buildLogin(student));
		return data;
	}

}
