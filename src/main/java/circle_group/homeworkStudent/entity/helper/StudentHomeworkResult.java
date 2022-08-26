package circle_group.homeworkStudent.entity.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "student_homework_result")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentHomeworkResult {

//    @Id
    private Integer id;

    private String name;

    private String phoneNumber;

    private String body;

    private String comment;

    private Integer overall;
}
