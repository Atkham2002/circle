package circle_group.homeworkStudent.service;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentHomeworkService {

    ResponseDto<StudentHomeworkDto> addNewStudentHomework(StudentHomeworkDto studentHomeworkDto);
    ResponseDto<Page<StudentHomeworkDto>> getAllStudentHomeworks();

    ResponseDto<StudentHomeworkDto> getStudentHomeworkById(Integer id);

    ResponseDto<StudentHomeworkDto> updateStudentHomework(StudentHomeworkDto studentHomeworkDto);

    ResponseDto<StudentHomeworkDto> deleteStudentHomeworkById(Integer id);
}
