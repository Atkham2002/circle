package circle_group.homeworkStudent.service.impl;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.TaskDto;
import circle_group.homeworkStudent.entity.Task;
import circle_group.homeworkStudent.repository.TaskRepository;
import circle_group.homeworkStudent.service.TaskService;
import circle_group.homeworkStudent.service.mapper.TaskMapper;
import circle_group.homeworkStudent.service.mapper.TaskMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
@RequiredArgsConstructor
public class TaskImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public ResponseDto<Object> addTask(TaskDto taskDto) {
        try {
            Task task = taskRepository.save(taskMapper.toEntity(taskDto));
            return ResponseDto.builder().success(true).message("successfully saved").code(200).data(taskMapper.toDto(task)).build();

        }catch (Exception e){
            return ResponseDto.builder().code(-3).message(e.getMessage()).success(false).build();
        }
    }

    @Override
    public ResponseDto<TaskDto> getById(Integer id) {
        return null;
    }

    @Override
    public ResponseDto<Page<TaskDto>> getAll(Integer page,Integer size) {
        return null;
    }

    @Override
    public ResponseDto<TaskDto> updateTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public ResponseDto<Task> deleteTask(Integer id) {
        return null;
    }

    @Override
    public ResponseDto<Page<TaskDto>> byParam(MultiValueMap<String, String> params) {
        return null;
    }
}
