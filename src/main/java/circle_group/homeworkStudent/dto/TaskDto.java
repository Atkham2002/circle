package circle_group.homeworkStudent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    @NotNull
    private Integer id;

    @NotNull
    private String body;

    @NotNull
    private String comment;
}
