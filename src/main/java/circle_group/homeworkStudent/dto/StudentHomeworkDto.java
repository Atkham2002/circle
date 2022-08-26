package circle_group.homeworkStudent.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentHomeworkDto {

    private Integer id;

    private StudentDto studentDto;

    private TaskDto taskDto;

    private Integer overall;
}
