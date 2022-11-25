package ae.rakbank.student.exception;

import ae.rakbank.student.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

import static ae.rakbank.student.utility.LogMessages.RESPONSE_SENT;

/**
 * @author imran
 * Global Exception Handler Class to handle application exceptions
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @param exception
     * @return
     */
    @ExceptionHandler({ StudentNotFoundException.class })
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(Exception exception) {
        log.info(RESPONSE_SENT, HttpStatus.NOT_FOUND.name());
        return new ResponseEntity<ErrorResponse>(ErrorResponse.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .statusDesc(HttpStatus.NOT_FOUND.name()).build(), HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param exception
     * @return
     */
    @ExceptionHandler({ StudentServiceException.class, HttpServerErrorException.InternalServerError.class})
    public ResponseEntity<ErrorResponse> handleStudentServiceException(Exception exception) {
        log.info(RESPONSE_SENT, HttpStatus.INTERNAL_SERVER_ERROR.name());
        return new ResponseEntity<ErrorResponse>(ErrorResponse.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .statusDesc(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .message(exception.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     *
     * @param exception
     * @return
     */
    @ExceptionHandler({ MethodArgumentTypeMismatchException.class, MethodArgumentNotValidException.class })
    public ResponseEntity<ErrorResponse> handleBadRequest(Exception exception) {
        log.info(RESPONSE_SENT, HttpStatus.BAD_REQUEST.name());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .statusDesc(HttpStatus.BAD_REQUEST.name())
                .build();
        if(exception instanceof MethodArgumentNotValidException) {
            Map<String, String> errors = new HashMap<>();
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) exception;
            ex.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            errorResponse.setMessage(errors.toString());
        }
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
