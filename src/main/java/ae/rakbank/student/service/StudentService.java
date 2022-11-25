package ae.rakbank.student.service;

import ae.rakbank.student.dto.StudentRequest;
import ae.rakbank.student.model.Student;
import ae.rakbank.student.exception.StudentNotFoundException;

public interface StudentService {

    public Student saveStudent(StudentRequest studentRequest);
    public Student findByStudentId(Integer studentId) throws StudentNotFoundException;
}
