package ae.rakbank.student.service.impl;

import ae.rakbank.student.dto.StudentRequest;
import ae.rakbank.student.model.Student;
import ae.rakbank.student.exception.StudentNotFoundException;
import ae.rakbank.student.repository.StudentRepository;
import ae.rakbank.student.service.StudentService;
import ae.rakbank.student.utility.StudentUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author imran
 * Service Layer for Student Microservice
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     *
     * @param studentRequest
     * @return
     */
    @Override
    public Student saveStudent(StudentRequest studentRequest) {
        return studentRepository.save(StudentUtility.convertToEntity(studentRequest));
    }

    /**
     *
     * @param studentId
     * @return
     * @throws StudentNotFoundException
     */
    @Override
    public Student findByStudentId(Integer studentId) throws StudentNotFoundException {

        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(!optionalStudent.isPresent()) {
            throw new StudentNotFoundException();
        }
        return optionalStudent.get();
    }
}
