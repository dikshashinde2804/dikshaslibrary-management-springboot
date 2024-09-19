
package in.techdenovo.dikshaapps.library_management_springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.techdenovo.dikshaapps.library_management_springboot.model.Author;
import in.techdenovo.dikshaapps.library_management_springboot.model.Book;
import in.techdenovo.dikshaapps.library_management_springboot.model.Student;
import in.techdenovo.dikshaapps.library_management_springboot.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@GetMapping("/add")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);

		return "addStudent";

	}

	@PostMapping("/add")
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.addStudent(student);
		return "redirect:/student/list";

	}

	@GetMapping("/list")
	public String allStudents(Model model) {
		List<Student> students = new ArrayList<>();
		students= studentService.allStudents();
		model.addAttribute("students", students);
		return "liststudent";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id,Model model) {
		studentService.deleteStudent(id);
		return "redirect:/student/list";
	}
	@GetMapping("/update/{id}")
	public String updateStudent(@PathVariable("id") int id,Model model) {
		Student existingStudent = studentService.findStudent(id);
		model.addAttribute("student", existingStudent);
		return "editstudent";
	}
	@PostMapping("/update")
	public String updateStudent(@ModelAttribute("student") Student student) {
		studentService.updateStudent(student);
		return "redirect:/student/list";
	}

}
