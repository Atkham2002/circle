package circle_group.homeworkStudent.controller;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.service.impl.StudentImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentImpl student;
    @GetMapping
    public ResponseDto<Page<StudentDto>> getAllStudent(@RequestParam MultiValueMap<String , String> params){
        System.out.println("getAll");
       return student.getALlStudent(params);
    }
    @PostMapping
    public ResponseDto addStudent(@RequestBody StudentDto studentDto){
       return student.addStudent(studentDto);
    }
    @GetMapping("/excel")
    public ResponseDto getExcelWrite() throws IOException {
        return student.getExcelWrite();
    }

}
