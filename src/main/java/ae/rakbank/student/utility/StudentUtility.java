package ae.rakbank.student.utility;

import ae.rakbank.student.dto.StudentRequest;
import ae.rakbank.student.model.Student;
import ae.rakbank.student.exception.StudentServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

/**
 * @author imran
 * Utility Class for Student Service
 */
@UtilityClass
public class StudentUtility {

    /**
     *
     * @param object
     * @return
     * @throws StudentServiceException
     */
    public static String convertToJson(Object object) throws StudentServiceException {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new StudentServiceException(e.getMessage());
        }
    }

    /**
     *
     * @param studentRequest
     * @return
     */
    public static Student convertToEntity(StudentRequest studentRequest) {
        return new ModelMapper().map(studentRequest, Student.class);
    }
}
