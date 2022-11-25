package ae.rakbank.student.controller;

import ae.rakbank.student.dto.StudentRequest;
import ae.rakbank.student.model.Student;
import ae.rakbank.student.exception.StudentNotFoundException;
import ae.rakbank.student.exception.StudentServiceException;
import ae.rakbank.student.service.impl.StudentServiceImpl;
import ae.rakbank.student.utility.StudentUtility;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static ae.rakbank.student.utility.LogMessages.*;

/**
 * @author imran
 * RestController for Student Microservice
 */
@Slf4j
@RestController
@RequestMapping("/rakbank/api/student")
@Tag(name = "Student API", description = "API for adding new Student and retrieving Student by studentId")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;


    /**
     * @param studentRequest
     * @return
     * @throws StudentServiceException
     */
    @ResponseBody
    @PostMapping
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody StudentRequest studentRequest) throws StudentServiceException {

        log.info(REQUEST_RECEIVED, StudentUtility.convertToJson(studentRequest));
        Student studentResponse = studentService.saveStudent(studentRequest);
        log.info(RESPONSE_SENT, StudentUtility.convertToJson(studentResponse));
        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
    }


    /**
     * @param studentId
     * @return
     * @throws StudentServiceException
     * @throws StudentNotFoundException
     */
    @ResponseBody
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> findByStudentId(@PathVariable Integer studentId) throws StudentServiceException, StudentNotFoundException {

        log.info(REQUEST_RECEIVED, studentId);
        Student studentResponse = studentService.findByStudentId(studentId);
        log.info(RESPONSE_SENT, StudentUtility.convertToJson(studentResponse));
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }
}
