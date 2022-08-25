package circle_group.homeworkStudent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    @NotNull(message = "bo'sh maydon")
    @Min(message = "manfiy qiymat", value = 0)
    private Integer id;

    @NotNull(message = "bo'sh maydon")
    private String body;

    @NotNull(message = "bo'sh maydon")
    private String comment;
}
