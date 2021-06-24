package com.xyzcorp.student.registration;

import com.xyzcorp.instructor.registration.domain.Student;
import com.xyzcorp.instructor.registration.domain.StudentDAO;
import com.xyzcorp.instructor.registration.domain.StudentDAOException;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;
import static org.easymock.EasyMock.verify;

public class StudentServiceTest {

    @Test
    public void testRegisterStudent() throws StudentDAOException, StudentServiceException {
        StudentDAO studentDAO = mock(StudentDAO.class);
        StudentService studentService = new StudentService(studentDAO);

        Student expected = new Student(1001L, "Ray", "Polansky", "001");

        expect(studentDAO.findByStudentId("001")).andReturn(Optional.empty());
        expect(studentDAO.persist(new Student("Ray", "Polansky", "001")))
            .andReturn(1001L);

        replay(studentDAO);

        Student actual = studentService.registerStudent("Ray", "Polansky", "001");

        verify(studentDAO);
        assertThat(actual).isEqualTo(expected);
    }
}
