package ae.rakbank.student;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author imran
 * SpringBoot Main Class for Student Microservice
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Student Service Definition",
		description = "Microservice for adding new Student and retrieving Student based on studentId",
		contact = @Contact(
			name = "Mohammad Imran",
			url= "https://www.linkedin.com/in/md-imran-02524a125/",
			email= "mailmeinfo.imran@gmail.com"
		),
		version = "v1"
))
public class RbStudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbStudentServiceApplication.class, args);
	}

}
