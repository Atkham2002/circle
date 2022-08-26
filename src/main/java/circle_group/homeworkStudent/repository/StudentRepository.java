package circle_group.homeworkStudent.repository;

import circle_group.homeworkStudent.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Integer> {

    Student findStudentByPhoneNumber(String phoneNumber);
}
