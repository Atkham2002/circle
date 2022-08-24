package circle_group.homeworkStudent.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentHomeworkDto {

    private Integer id;

    private List<StudentDto> studentDtoList;

    private List<TaskDto> taskDtoList;

    private Integer overall;
}
