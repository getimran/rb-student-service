package ae.rakbank.student.utility;

import ae.rakbank.student.dto.StudentRequest;
import ae.rakbank.student.model.Student;

public class TestUtility {


    public static Student getStudent() {
        Student student = new Student();
        student.setStudentId(1001);
        student.setStudentName("Imran");
        student.setGrade("5");
        student.setSchoolName("MGM English School");
        student.setMobileNum("9998889991");
        return student;
    }

    public static StudentRequest getStudentRequest() {
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setStudentName("Imran");
        studentRequest.setGrade("5");
        studentRequest.setSchoolName("MGM English School");
        studentRequest.setMobileNum("9998889991");
        return studentRequest;
    }
}
