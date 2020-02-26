package com.student.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StudentRepository {

	private List<Student> studentRecords;

	private static StudentRepository stdregd = null;

	private StudentRepository() {
		studentRecords = new ArrayList<Student>();
	}

	public static StudentRepository getInstance() {

		if (stdregd == null) {
			stdregd = new StudentRepository();
			return stdregd;
		} else {
			return stdregd;
		}
	}

	public void add(Student std) {
		studentRecords.add(std);
	}

	public String upDateStudent(Student std) {

		for (int i = 0; i < studentRecords.size(); i++) {
			Student stdn = studentRecords.get(i);
			System.out.println(stdn.getRegistrationNumber());// very bad
			System.out.println(std.getRegistrationNumber()); // very bad
			// bug here hello :)
			if (stdn.getRegistrationNumber() == std.getRegistrationNumber()) {
				studentRecords.set(i, std);// update the new record
				return "Update successful";
			}
		}
		return "Update un-successful";
	}

	public String deleteStudent(Integer registrationNumber) {

		for (int i = 0; i < studentRecords.size(); i++) {
			Student stdn = studentRecords.get(i);
			// bug here ! hello :)
			if (stdn.getRegistrationNumber() == registrationNumber) {
				studentRecords.remove(i);
				return "Delete successful";
			}
		}
		return "Delete un-successful";
	}

	public Date getExamScheduleFor(Integer registrationNumber, String topic) {

		Student student = getStudentByRegNumber(registrationNumber);

		if (student != null) {

			if (student.getExamSchedule().containsKey(topic)) {
				// bug here hello :)
				return student.getExamSchedule().get(topic);
			}
		}
		return null;// bad practice
	}

	public Student getStudentByRegNumber(Integer registrationNumber) {

		for (int i = 0; i < studentRecords.size(); i++) {
			Student stdn = studentRecords.get(i);
			// bug here hello :)
			if (stdn.getRegistrationNumber() == registrationNumber) {
				return studentRecords.get(i);
			}
		}
		return null;// bad practice
	}

	public List<Student> getStudentRecords() {
		return studentRecords;
	}

	/**
	 * for Laurent -> u32324237622rent
	 * 
	 * @param student
	 * @return
	 */
	public String buildLogin(Student student) {

		// bug here hello :)
		String name = student.getName();

		// bug here :)
		name.replace(" ", "");

		// bug here hello :)
		char secondCharacter = name.charAt(2);

		// bug here hello :)
		String lastPartOfTheName = name.substring(name.indexOf(secondCharacter));

		// bug here hello :)
		String login = secondCharacter + new Date().getTime() + lastPartOfTheName;

		// bug here hello
		int position = login.indexOf(' ');
		// bug here
		if (login.substring(position).length() == 0)
			System.out.println("login has whitespace =" + login);

		return login;

	}

	public String generatePGP() {

		String pgp = "";
		int i = 0;
		while (i < 100) {

			pgp += UUID.randomUUID() + "\n";// extremely bad
			i++;
		}
		return pgp;
	}

}
