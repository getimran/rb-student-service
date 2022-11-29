package ae.rakbank.student.controller;

import ae.rakbank.student.dto.StudentRequest;
import ae.rakbank.student.exception.StudentNotFoundException;
import ae.rakbank.student.exception.StudentServiceException;
import ae.rakbank.student.model.Student;
import ae.rakbank.student.service.impl.StudentServiceImpl;
import ae.rakbank.student.utility.TestUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentControllerTest {

    @InjectMocks
    StudentController studentController;

    @Mock
    private StudentServiceImpl studentService;

    @Test
    public void testSaveStudent() throws StudentServiceException {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(studentService.saveStudent(Mockito.any(StudentRequest.class)))
                .thenReturn(TestUtility.getStudent());
        ResponseEntity<Student> studentResponse = studentController.saveStudent(TestUtility.getStudentRequest());
        Assertions.assertEquals(201, studentResponse.getStatusCodeValue());
    }

    @Test
    public void testFindByStudentId() throws StudentServiceException, StudentNotFoundException {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(studentService.findByStudentId(Mockito.anyInt()))
                .thenReturn(TestUtility.getStudent());
        ResponseEntity<Student> studentResponse = studentController.findByStudentId(1001);
        Assertions.assertEquals(200, studentResponse.getStatusCodeValue());
    }

}
