package com.cts.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cts.bean.Student;

@RestController
public class StudentController {
	@GetMapping("/student")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Rajesh","Khanna"));
		students.add(new Student(2,"Jay","Reddy"));
		students.add(new Student(3,"Mani","Don"));
		return students;
	}
	@GetMapping("/students/{id}")
	public Student studentPathVariable(@PathVariable("id") int studentId) {
		return new Student(studentId,"Priya","Mahajan");
	}
	@GetMapping("/students/query")
	public Student studentRequestVariable(@RequestParam int id,@RequestParam String firstname,@RequestParam String lastname){
	return new Student(id,firstname,lastname);
}
	@PostMapping("/students/create")
			@ResponseStatus(HttpStatus.CREATED)
			public Student createstudent (@RequestBody Student student) {
			System.out.println(student.getId());
			System.out.println(student.getFirstname());
			System.out.println(student.getLastname());
			return student;
}

}


