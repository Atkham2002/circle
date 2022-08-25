package circle_group.homeworkStudent.controller;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.TaskDto;
import circle_group.homeworkStudent.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(name = "task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    public ResponseDto<Object> addTask(@Valid @RequestBody TaskDto taskDto){
        return taskService.addTask(taskDto);
    }

    @GetMapping
    public ResponseDto<Page<TaskDto>> getAll(@RequestParam Integer page, @RequestParam Integer size){
        return taskService.getAll(page, size);
    }

}
