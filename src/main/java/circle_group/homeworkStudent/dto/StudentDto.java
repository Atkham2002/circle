package circle_group.homeworkStudent.dto;

import circle_group.homeworkStudent.entity.StudentHomework;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Integer id;
    private String name;
    private String phoneNumber;
//    private List<StudentHomeworkDto>homeworkDtos;

}
