package circle_group.homeworkStudent.service.mapper;

import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import circle_group.homeworkStudent.entity.StudentHomework;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentHomeworkMapper {

    StudentHomework toEntity(StudentHomeworkDto studentHomeworkDto);

    StudentHomeworkDto toDto (StudentHomework studentHomework);
}
