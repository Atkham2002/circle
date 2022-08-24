package circle_group.homeworkStudent.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentHomeworkDto {

    private Integer id;

    private StudentDto studentDto;

    private TaskDto taskDto;

    private Integer overall;
}
