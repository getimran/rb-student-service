package ae.rakbank.student.utility;

import lombok.experimental.UtilityClass;

/**
 * @author imran
 * Constant class for Student Service
 */
@UtilityClass
public class AppConstants {

    public static final String MOB_NUM_REGEX = "^[0][1-9]\\d{9}$|^[1-9]\\d{9}$";
    public static final String MOB_NUM_VALIDATION_MESSAGE = "invalid mobile  number";
    public static final String STUDENT_SEQ = "student_seq";
    public static final String STUDENT_SEQ_GENERATOR = "ae.rakbank.student.generator.StudentSequenceIdPrefixGenerator";
    public static final String STUDENT_SEQ_PREFIX = "100";
}
