package circle_group.homeworkStudent.service;
import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentDto;
import org.springframework.data.domain.Page;

public interface StudentService {
    ResponseDto<Page<StudentDto>> getALlStudent();
    ResponseDto <StudentDto> getByIdStudent(Integer id);
    ResponseDto<StudentDto> updateStudent(StudentDto studentDto);
    ResponseDto<StudentDto> deleteStudent(Integer id);
}
