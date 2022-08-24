package circle_group.homeworkStudent.controller;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.service.impl.StudentImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentImpl student;
    @GetMapping
    public ResponseDto<Page<StudentDto>> getAll(@RequestParam Integer size, @RequestParam Integer page){
       return student.getALlStudent(size,page);
    }
}
