package circle_group.homeworkStudent.repository;

import circle_group.homeworkStudent.entity.StudentHomework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentHomeworkRepository extends JpaRepository<StudentHomework, Integer> {

    boolean existsStudentHomeworkByStudentId(Integer student_id);

    boolean existsStudentHomeworkByTaskId(Integer task_id);
}
