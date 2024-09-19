package in.techdenovo.dikshaapps.library_management_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.techdenovo.dikshaapps.library_management_springboot.model.Book;
import in.techdenovo.dikshaapps.library_management_springboot.model.Category;
import in.techdenovo.dikshaapps.library_management_springboot.model.Student;
import in.techdenovo.dikshaapps.library_management_springboot.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
		
	}
	public List<Student> allStudents() {
		
		return studentRepository.findAll();
	}
	
	public void deleteStudent(int id) {
		
		Student existingStudent = studentRepository.findById(id).orElse(null);
		if(existingStudent!=null) {
			studentRepository.delete(existingStudent);
		}
	}
	public Student findStudent(int id) {
		return studentRepository.findById(id).orElse(null);
	}
	public Student updateStudent(Student student) {
		Student existingStudent = studentRepository.findById(student.getStudentId()).orElse(null);
		if(existingStudent!=null) {
			existingStudent.setFirstName(student.getFirstName());
			existingStudent.setLastName(student.getLastName());
			existingStudent.setPhoneNo(student.getPhoneNo());
			existingStudent.setEmail(student.getEmail());
			existingStudent.setLocation(student.getLocation());
		}
		return studentRepository.save(existingStudent);
		
	}
	public long countStudents() {
		return studentRepository.count();
	}
	
}
