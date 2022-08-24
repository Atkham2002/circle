package circle_group.homeworkStudent.service.mapper;

import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentDto dto);

    StudentDto toDto(Student student);
}
