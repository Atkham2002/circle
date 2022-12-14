package circle_group.homeworkStudent.service;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface StudentHomeworkService {

    ResponseDto<StudentHomeworkDto> addNewStudentHomework(StudentHomeworkDto studentHomeworkDto);
    ResponseDto<Page<StudentHomeworkDto>> getAllStudentHomeworks(Integer page, Integer size);

    ResponseDto<String> setStudentHomeworkToExcel(HttpServletResponse response);

    ResponseDto<StudentHomeworkDto> getStudentHomeworkById(Integer id);

    ResponseDto<StudentHomeworkDto> updateStudentHomework(StudentHomeworkDto studentHomeworkDto);

    ResponseDto<StudentHomeworkDto> deleteStudentHomeworkById(Integer id);
}
