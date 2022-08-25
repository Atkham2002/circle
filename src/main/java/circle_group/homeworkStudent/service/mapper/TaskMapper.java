package circle_group.homeworkStudent.service.mapper;

import circle_group.homeworkStudent.dto.TaskDto;
import circle_group.homeworkStudent.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task toEntity(TaskDto taskDto);

    TaskDto toDto(Task task);

}
