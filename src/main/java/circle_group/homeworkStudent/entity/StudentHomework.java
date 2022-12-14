package circle_group.homeworkStudent.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student_homework")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentHomework {

    @Id
    @GeneratedValue(generator = "student_homework_generator")
    @SequenceGenerator(name = "student_homework_generator", sequenceName = "student_homework_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private Integer overall;
}
