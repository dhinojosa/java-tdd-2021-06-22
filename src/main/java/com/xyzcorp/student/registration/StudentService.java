package com.xyzcorp.student.registration;

import com.xyzcorp.instructor.registration.domain.Student;
import com.xyzcorp.instructor.registration.domain.StudentDAO;

import java.util.Optional;

public class StudentService {
    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Student registerStudent(String firstName, String lastName, String studentId) throws StudentServiceException {
        Optional<Student> maybeStudent = studentDAO.findByStudentId(studentId);
        if (maybeStudent.isEmpty()) {
            Long id = studentDAO.persist(new Student(firstName, lastName, studentId));
            return new Student(id, firstName, lastName, studentId);
        }
        throw new StudentServiceException("Student is already registered");
    }
}
