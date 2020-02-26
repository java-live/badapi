package com.student.beans;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Student {

	String name;
	int age;
	Integer registrationNumber;
	final Map<String, Date> examSchedule = new ConcurrentHashMap<String, Date>();
	String pgp;

	public String getPgp() {
		return pgp;
	}

	public void setPgp(String pgp) {
		this.pgp = pgp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(Integer registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Map<String, Date> getExamSchedule() {
		return examSchedule;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", registrationNumber=" + registrationNumber + "]";
	}
}
