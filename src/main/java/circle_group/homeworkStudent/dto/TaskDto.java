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
public class TaskDto {
    private Integer id;
    private String body;

    private List<StudentHomeworkDto> homeworks;

    private String comment;
}
