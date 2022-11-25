package ae.rakbank.student.repository;


import ae.rakbank.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author imran
 * Repository Layer for Student Microservice
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
