package circle_group.homeworkStudent.service.impl;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import circle_group.homeworkStudent.entity.StudentHomework;
import circle_group.homeworkStudent.repository.StudentHomeworkRepository;
import circle_group.homeworkStudent.repository.StudentRepository;
import circle_group.homeworkStudent.repository.TaskRepository;
import circle_group.homeworkStudent.service.StudentHomeworkService;
import circle_group.homeworkStudent.service.mapper.StudentHomeworkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentHomeworkServiceImpl implements StudentHomeworkService {

    private final StudentHomeworkRepository studentHomeworkRepository;

    private final StudentRepository studentRepository;

    private final TaskRepository taskRepository;

    private final StudentHomeworkMapper studentHomeworkMapper;

    @Override
    public ResponseDto<StudentHomeworkDto> addNewStudentHomework(StudentHomeworkDto studentHomeworkDto) {
        System.out.println(studentHomeworkDto);
        String result = checkStudentAndTask(studentHomeworkDto);
        if (result.equals("Student is not exists") || result.equals("Task is not exists")){
            return ResponseDto.<StudentHomeworkDto>builder()
                    .code(-1).success(false).message(result).build();
        }

        StudentHomework studentHomework = studentHomeworkMapper.toEntity(studentHomeworkDto);
        if(checkStudentHomeworkTable(studentHomework)){
            return ResponseDto.<StudentHomeworkDto>builder()
                    .code(-1).success(false).message("This combination is already exists!").build();
        }

        studentHomework = studentHomeworkRepository.save(studentHomework);

        return ResponseDto.<StudentHomeworkDto>builder()
                .code(1).success(true).message("OK").data(studentHomeworkMapper.toDto(studentHomework)).build();
    }

    @Override
    public ResponseDto<Page<StudentHomeworkDto>> getAllStudentHomeworks(Integer page, Integer size) {
        if(page == null || size == null){
            return ResponseDto.<Page<StudentHomeworkDto>>builder()
                    .code(-2).success(false).message("Page or size is not given!").build();
        }
        if(page < 0 || size < 0){
            return ResponseDto.<Page<StudentHomeworkDto>>builder()
                    .code(-2).success(false).message("Page or size is below from 0").build();
        }
        PageRequest request = PageRequest.of(page, size);
        Page<StudentHomeworkDto> pageNation = studentHomeworkRepository.findAll(request).map(studentHomeworkMapper::toDto);

        return ResponseDto.<Page<StudentHomeworkDto>>builder()
                .code(1).success(true).message("OK").data(pageNation).build();
    }

    @Override
    public ResponseDto<String> setStudentHomeworkToExcel() {




        return null;
    }

    @Override
    public ResponseDto<StudentHomeworkDto> getStudentHomeworkById(Integer id) {
        return null;
    }

    @Override
    public ResponseDto<StudentHomeworkDto> updateStudentHomework(StudentHomeworkDto studentHomeworkDto) {
        return null;
    }

    @Override
    public ResponseDto<StudentHomeworkDto> deleteStudentHomeworkById(Integer id) {
        return null;
    }

    private String checkStudentAndTask(StudentHomeworkDto studentHomeworkDto){
        if(!studentRepository.existsById(studentHomeworkDto.getStudentDto().getId())){
            return "Student is not exists";
        }
        if(!taskRepository.existsById(studentHomeworkDto.getTaskDto().getId())){
            return "Task is not exists";
        }
        return null;
    }

    private boolean checkStudentHomeworkTable(StudentHomework studentHomework){
        if(studentHomeworkRepository.existsStudentHomeworkByStudentId(studentHomework.getStudent().getId())
           &&
           studentHomeworkRepository.existsStudentHomeworkByTaskId(studentHomework.getTask().getId())
        ){
            return false;
        }

        return true;
    }
}
