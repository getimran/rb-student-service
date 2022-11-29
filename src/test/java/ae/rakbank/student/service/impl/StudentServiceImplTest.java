package ae.rakbank.student.service.impl;

import ae.rakbank.student.dto.StudentRequest;
import ae.rakbank.student.exception.StudentNotFoundException;
import ae.rakbank.student.model.Student;
import ae.rakbank.student.repository.StudentRepository;
import ae.rakbank.student.utility.TestUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    StudentServiceImpl studentService;

    @Test
    public void testSaveStudent() {
        Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(TestUtility.getStudent());
        Student student = studentService.saveStudent(new StudentRequest());
        Mockito.verify(studentRepository, Mockito.times(1)).save(Mockito.any(Student.class));
        Assertions.assertEquals(1001, student.getStudentId());
    }

    @Test
    public void testFindByStudentIdForSuccess() throws StudentNotFoundException {
        Mockito.when(studentRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(TestUtility.getStudent()));
        Student student = studentService.findByStudentId(1001);
        Mockito.verify(studentRepository, Mockito.times(1)).findById(Mockito.anyInt());
        Assertions.assertEquals(1001, student.getStudentId());
    }

    @Test
    public void testFindByStudentIdForNotFound() {
        Mockito.when(studentRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        StudentNotFoundException exception = Assertions
                .assertThrows(StudentNotFoundException.class, () -> studentService.findByStudentId(1001));
        Assertions.assertNotNull(exception);
    }

}
