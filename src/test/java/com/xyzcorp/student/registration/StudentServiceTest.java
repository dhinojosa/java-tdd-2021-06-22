package com.xyzcorp.student.registration;

import com.xyzcorp.instructor.registration.domain.Student;
import com.xyzcorp.instructor.registration.domain.StudentDAO;
import com.xyzcorp.instructor.registration.domain.StudentDAOException;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.easymock.EasyMock.*;
import static org.easymock.EasyMock.verify;

public class StudentServiceTest {

    @Test
    public void testRegisterStudent() throws StudentDAOException, StudentServiceException {
        StudentDAO studentDAO = mock(StudentDAO.class);

        //StudentService = Subject under test
        StudentService studentService = new StudentService(studentDAO);


        // expectation
        Student expected = new Student(1001L, "Ray", "Polansky", "001");
        expect(studentDAO.findByStudentId("001")).andReturn(Optional.empty());
        expect(studentDAO.persist(new Student("Ray", "Polansky", "001")))
            .andReturn(1001L);

        //replay - only needed for EasyMock

        replay(studentDAO);

        //actual run
        Student actual = studentService.registerStudent("Ray", "Polansky", "001");

        verify(studentDAO);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testRegisterStudentShouldDoSomethingIfNotThere() throws StudentDAOException, StudentServiceException {
        StudentDAO studentDAO = mock(StudentDAO.class);

        //StudentService = Subject under test
        StudentService studentService = new StudentService(studentDAO);

        // expectation
        Student expected = new Student(1001L, "Ray", "Polansky", "001");
        expect(studentDAO.findByStudentId("001")).andReturn(Optional.of(expected));

        //replay - only needed for EasyMock

        replay(studentDAO);

        //actual run
        assertThatThrownBy(() -> studentService.registerStudent("Ray", "Polansky", "001"))
            .isInstanceOf(StudentServiceException.class)
            .hasMessage("Student is already registered");

        verify(studentDAO);
    }
}
