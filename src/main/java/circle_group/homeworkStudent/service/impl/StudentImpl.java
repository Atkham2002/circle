package circle_group.homeworkStudent.service.impl;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.entity.Student;
import circle_group.homeworkStudent.repository.StudentRepository;
import circle_group.homeworkStudent.service.StudentService;
import circle_group.homeworkStudent.service.mapper.StudentMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public ResponseDto<Page<StudentDto>> getALlStudent(Integer size,Integer page) {
        PageRequest pageRequest =PageRequest.of(size,page);
        Page<StudentDto> students = studentRepository.findAll(pageRequest).map(studentMapper::toDto);
        return ResponseDto.<Page<StudentDto>>builder().message("ok").success(true).code(2).data(students).build();
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

    @Override
    public ResponseDto addStudent(StudentDto studentDto) {
        studentRepository.save(studentMapper.toEntity(studentDto));
        return ResponseDto.builder().code(2).message("ok").success(true).data(studentDto).build();
    }

    @Override
    public ResponseDto getExcel() {
        return null;
    }
}
