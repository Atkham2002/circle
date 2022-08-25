package circle_group.homeworkStudent.controller;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import circle_group.homeworkStudent.service.impl.StudentHomeworkServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homework")
@RequiredArgsConstructor
public class StudentHomeworkController {

    private final StudentHomeworkServiceImpl service;

    @PostMapping
    public ResponseDto<StudentHomeworkDto> addNewStudentHomework(@RequestBody StudentHomeworkDto studentHomeworkDto){
        return service.addNewStudentHomework(studentHomeworkDto);
    }

    @GetMapping
    public ResponseDto<Page<StudentDto>> getAllStudent(@RequestParam Integer page, @RequestParam Integer size){
        return null;
    }
}
