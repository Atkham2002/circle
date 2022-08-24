package circle_group.homeworkStudent.controller;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import circle_group.homeworkStudent.service.impl.StudentHomeworkServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("homework")
@RequiredArgsConstructor
public class StudentHomeworkController {

    private final StudentHomeworkServiceImpl service;

    @PostMapping
    public ResponseDto<StudentHomeworkDto> addNewStudentHomework(StudentHomeworkDto studentHomeworkDto){
        return service.addNewStudentHomework(studentHomeworkDto);
    }
}
