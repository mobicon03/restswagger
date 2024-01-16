package com.sama.restswagger.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sama.restswagger.model.Student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "StudentRestController", description = "REST Apis related to Student Entity!!!!")
@RestController
public class StudentRestController {

	List<Student> students = new ArrayList<Student>();
	{
		students.add(new Student("Sajal", "IV", "India"));
		students.add(new Student("Lokesh", "V", "India"));
		students.add(new Student("Kajal", "III", "USA"));
		students.add(new Student("Sukesh", "VI", "USA"));
	}

	@ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })

	@RequestMapping(value = "/getStudents")
	public List<Student> getStudents() {
		System.out.println("getStudents() - " + "N/A");
		return students;
	}

	@ApiOperation(value = "Get specific Student in the System ", response = Student.class, tags = "getStudent")
	@RequestMapping(value = "/getStudent/{name}")
	public Student getStudent(@PathVariable(value = "name") String name) {
		System.out.println("getStudent() - " + "name:"+name);
		Student studentsResult = null;
		for (Student c : students) {
			if (c.getName().equals(name)) {
				studentsResult = c;
			}
		}
		return studentsResult;
	}

	@ApiOperation(value = "Get specific Student By Country in the System ", response = Student.class, tags = "getStudentByCountry")
	@RequestMapping(value = "/getStudentByCountry/{country}")
	public List<Student> getStudentByCountry(@PathVariable(value = "country") String country) {
		System.out.println("getStudentByCountry() - " + "country:"+country);
		List<Student> studentsResult = new ArrayList<Student>();
		for (Student c : students) {
			if (c.getCountry().equals(country)) {
				studentsResult.add(c);

			}
		}
		return studentsResult;
	}

	 @ApiOperation(value = "Get specific Student By Class in the System ",response = Student.class,tags="getStudentByClass")
	@RequestMapping(value = "/getStudentByClass/{cls}")
	public List<Student> getStudentByClass(@PathVariable(value = "cls") String cls) {
		List<Student> studentsResult = new ArrayList<Student>();
		for (Student c : students) {
			if (c.getCls().equals(cls)) {
				studentsResult.add(c);
			}
		}
		return studentsResult;
	}

}
