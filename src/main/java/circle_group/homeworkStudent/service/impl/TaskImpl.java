package circle_group.homeworkStudent.service.impl;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.TaskDto;
import circle_group.homeworkStudent.entity.Task;
import circle_group.homeworkStudent.repository.TaskRepository;
import circle_group.homeworkStudent.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
@RequiredArgsConstructor
public class TaskImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public ResponseDto<String> addTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public ResponseDto<TaskDto> getById(Integer id) {
        return null;
    }

    @Override
    public ResponseDto<Page<TaskDto>> getAll() {
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
