package circle_group.homeworkStudent.service;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.TaskDto;
import circle_group.homeworkStudent.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;

public interface TaskService {

    ResponseDto<Object> addTask(TaskDto taskDto);

    ResponseDto<TaskDto> getById(Integer id);

    ResponseDto<Page<TaskDto>> getAll(Integer page, Integer size);

    ResponseDto<TaskDto> updateTask(TaskDto taskDto);

    ResponseDto<Task> deleteTask(Integer id);

    ResponseDto<Page<TaskDto>> byParam(MultiValueMap<String,String> params);


}
