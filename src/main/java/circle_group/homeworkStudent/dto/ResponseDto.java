package circle_group.homeworkStudent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResponseDto<T> {
    private Integer code;

    private Boolean success;

    private String message;

    private T data;
    private List<ValidatorDto> errors;
}
