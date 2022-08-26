package circle_group.homeworkStudent.controller;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import circle_group.homeworkStudent.service.impl.StudentHomeworkServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
    public ResponseDto<Page<StudentHomeworkDto>> getAllStudent(@RequestParam Integer page, @RequestParam Integer size){
        return service.getAllStudentHomeworks(page, size);
    }

    @GetMapping("/excel-export")
    public ResponseDto<String> getExcelString(HttpServletResponse response){
        return service.setStudentHomeworkToExcel(response);
    }
}
