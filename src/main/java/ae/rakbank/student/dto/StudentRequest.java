package ae.rakbank.student.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static ae.rakbank.student.utility.AppConstants.*;

/**
 * @author imran
 * Request DTO for Student
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentRequest {

    @NotBlank
    @Pattern(regexp=REGEX_ONLY_LETTERS, message=ONLY_LETTERS_ALLOWED)
    private String studentName;

    @NotBlank
    private String grade;

    @NotBlank
    private String schoolName;

    @Pattern(regexp=REGEX_MOB_NUM, message=MOB_NUM_VALIDATION_MESSAGE)
    private String mobileNum;
}
