package ae.rakbank.student.model;

import ae.rakbank.student.generator.StudentSequenceIdPrefixGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static ae.rakbank.student.utility.AppConstants.*;

/**
 * @author imran
 * Entity class for Student
 */
@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = STUDENT_SEQ)
    @GenericGenerator(
            name = STUDENT_SEQ,
            strategy = STUDENT_SEQ_GENERATOR,
            parameters = {
                    @Parameter(name =
                            StudentSequenceIdPrefixGenerator.VALUE_PREFIX_PARAMETER, value =
                            STUDENT_SEQ_PREFIX)})
    private Integer studentId;

    private String studentName;
    private String grade;
    private String schoolName;
    private String mobileNum;

}
