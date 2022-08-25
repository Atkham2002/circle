package circle_group.homeworkStudent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    @NotBlank(message = "bo'sh maydon")
    @Min(message = "manfiy qiymat", value = 0)
    private Integer id;

    @NotBlank(message = "bo'sh maydon")
    private String body;

    @NotBlank(message = "bo'sh maydon")
    private String comment;
}
