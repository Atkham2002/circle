package circle_group.homeworkStudent.service.mapper;

import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import circle_group.homeworkStudent.entity.StudentHomework;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentHomeworkMapper {

    @Mapping(target = "student", source = "studentHomeworkDto.studentDto")
    @Mapping(target = "task", source = "studentHomeworkDto.taskDto")
    StudentHomework toEntity(StudentHomeworkDto studentHomeworkDto);

    @Mapping(target = "studentDto", source = "studentHomework.student")
    @Mapping(target = "taskDto", source = "studentHomework.task")
    StudentHomeworkDto toDto(StudentHomework studentHomework);
}
