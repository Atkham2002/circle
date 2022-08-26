package circle_group.homeworkStudent.service.impl;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import circle_group.homeworkStudent.dto.TaskDto;
import circle_group.homeworkStudent.entity.Student;
import circle_group.homeworkStudent.entity.StudentHomework;
import circle_group.homeworkStudent.entity.Task;
import circle_group.homeworkStudent.my_model.MultiDomain;
import circle_group.homeworkStudent.my_model.StudentScores;
import circle_group.homeworkStudent.repository.StudentHomeworkRepository;
import circle_group.homeworkStudent.repository.StudentRepository;
import circle_group.homeworkStudent.repository.TaskRepository;
import circle_group.homeworkStudent.repository.helper.StudentHomeworkQH;
import circle_group.homeworkStudent.service.StudentHomeworkService;
import circle_group.homeworkStudent.service.excel.impl.StudentHomeworkExcelServiceImpl;
import circle_group.homeworkStudent.service.mapper.StudentHomeworkMapper;
import circle_group.homeworkStudent.service.mapper.StudentMapper;
import circle_group.homeworkStudent.service.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentHomeworkServiceImpl implements StudentHomeworkService {

    private final StudentHomeworkRepository studentHomeworkRepository;

    private final StudentRepository studentRepository;

    private final TaskRepository taskRepository;

    private final StudentHomeworkMapper studentHomeworkMapper;

    private final TaskMapper taskMapper;

    private final StudentMapper studentMapper;

    private final StudentHomeworkExcelServiceImpl excelService;

    private final StudentHomeworkQH qh;


    @Override
    public ResponseDto<StudentHomeworkDto> addNewStudentHomework(StudentHomeworkDto studentHomeworkDto) {
        System.out.println(studentHomeworkDto);
        String result = checkStudentAndTask(studentHomeworkDto);

        if (result.equals("Student is not exists") || result.equals("Task is not exists")){
            return ResponseDto.<StudentHomeworkDto>builder()
                    .code(-1).success(false).message(result).build();
        }

        StudentHomework studentHomework = myDtoConverter(studentHomeworkDto);
//        StudentHomework studentHomework = studentHomeworkMapper.toEntity(studentHomeworkDto);
//        System.out.println(studentHomework);
        if(!checkStudentHomeworkTable(studentHomework)){
            return ResponseDto.<StudentHomeworkDto>builder()
                    .code(-1).success(false).message("This combination is already exists!").build();
        }
        studentHomework = studentHomeworkRepository.save(studentHomework);

        StudentHomeworkDto dto = myEntityConverter(studentHomework);
//        StudentHomeworkDto dto = studentHomeworkMapper.toDto(studentHomework);
//        System.out.println(dto);
        return ResponseDto.<StudentHomeworkDto>builder()
                .code(1).success(true).message("OK").data(dto).build();
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
    public ResponseDto<String> setStudentHomeworkToExcel(HttpServletResponse response) {

        List<MultiDomain> domainList = qh.returnPerfectAnswer();
        List<TaskDto> taskDtoList = taskRepository.findAll().stream()
                .map(taskMapper::toDto).toList();

        HashMap<StudentDto, List<MultiDomain>> map = convertListToMap(domainList);
        excelService.writeEntityToExcel(map, taskDtoList, response);

        return ResponseDto.<String>builder().code(0).success(true).message("OK").data("File skachat bo'ldi.").build();
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
        return "OK";
    }

    private boolean checkStudentHomeworkTable(StudentHomework studentHomework){
//        System.out.println(studentHomework.getStudent() + "\t\t" + studentHomework.getTask());
        if(studentHomeworkRepository.existsStudentHomeworkByStudentId(studentHomework.getStudent().getId())
           &&
           studentHomeworkRepository.existsStudentHomeworkByTaskId(studentHomework.getTask().getId())
        ){
            return false;
        }

        return true;
    }

    private StudentHomework myDtoConverter(StudentHomeworkDto dto){
        int student_id = dto.getStudentDto().getId(), task_id = dto.getTaskDto().getId();
        StudentHomework studentHomework = studentHomeworkMapper.toEntity(dto);

        Optional<Student> optionalStudent = studentRepository.findById(student_id);
        Optional<Task> optionalTask = taskRepository.findById(task_id);

        if(optionalStudent.isEmpty() || optionalTask.isEmpty()) return null;

        Student student = optionalStudent.get();
        Task task = optionalTask.get();

        studentHomework.setStudent(student);
        studentHomework.setTask(task);

        return studentHomework;
    }

    private StudentHomeworkDto myEntityConverter(StudentHomework studentHomework){
        Student student = studentHomework.getStudent();
        Task task = studentHomework.getTask();

        return StudentHomeworkDto.builder()
                .id(studentHomework.getId())
                .studentDto(studentMapper.toDto(student))
                .taskDto(taskMapper.toDto(task))
                .overall(studentHomework.getOverall())
                .build();
    }

    private HashMap<StudentDto, List<MultiDomain>> convertListToMap(List<MultiDomain> domains){
        HashMap<StudentDto, List<MultiDomain>> map = new HashMap<>();

        for(MultiDomain md: domains){
            StudentDto s = StudentDto.builder().name(md.getName()).phoneNumber(md.getPhoneNumber()).build();
            if(map.containsKey(s)){
                map.get(s).add(md);

            }else{
                List<MultiDomain> list = new ArrayList<>();
                list.add(md);
                map.put(s, list);
            }
        }

        return map;
    }

}
