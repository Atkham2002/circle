package circle_group.homeworkStudent.service.impl;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class StudentImpl implements StudentService {
    @Override
    public ResponseDto<Page<StudentDto>> getALlStudent() {
        return null;
    }

    @Override
    public ResponseDto<StudentDto> getByIdStudent(Integer id) {
        return null;
    }

    @Override
    public ResponseDto<StudentDto> updateStudent(StudentDto studentDto) {
        return null;
    }

    @Override
    public ResponseDto<StudentDto> deleteStudent(Integer id) {
        return null;
    }
}
