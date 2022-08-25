package circle_group.homeworkStudent.service.impl;
import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.dto.ValidatorDto;
import circle_group.homeworkStudent.entity.Student;
import circle_group.homeworkStudent.repository.StudentRepository;
import circle_group.homeworkStudent.repository.impl.StudentRepositoryImpl;
import circle_group.homeworkStudent.service.StudentService;
import circle_group.homeworkStudent.service.mapper.StudentMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@Service
public class StudentImpl implements StudentService {
    private final StudentRepositoryImpl studentRepositoryImpl;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ValidatorServiceImpl validatorService;

    public StudentImpl(StudentRepositoryImpl studentRepositoryImpl, StudentRepository studentRepository, StudentMapper studentMapper, ValidatorServiceImpl validatorService) {
        this.studentRepositoryImpl = studentRepositoryImpl;
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.validatorService = validatorService;
    }
    @Override
    public ResponseDto<Page<StudentDto>>getALlStudent(MultiValueMap<String,String> params) {
        if(!params.containsKey("size") || ! params.containsKey("page")){
            return ResponseDto.<Page<StudentDto>>builder().code(-1).message("size or page is null").success(false).build();
        }
        PageRequest pageRequest =PageRequest.of(Integer.parseInt(params.getFirst("page")),Integer.parseInt(params.getFirst("size")));
        Page<StudentDto> students = studentRepositoryImpl.findByParms(pageRequest,params).map(studentMapper::toDto);
        students.forEach(System.out::println);
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
        List<ValidatorDto> errors = validatorService.validatorStudent(studentDto);
        if(!errors.isEmpty()){
            return ResponseDto.builder().errors(errors).data("Validator errors").success(false).code(-2).build();
        }
        studentRepository.save(studentMapper.toEntity(studentDto));
        return ResponseDto.builder().code(2).message("ok").success(true).data(studentDto).build();

    }

    @Override
    public ResponseDto getExcelWrite() throws IOException {
        List<Student> students = studentRepository.findAll();
        File file = new File("src\\main\\resources\\templates\\Excelfile.xlsx");
        file.createNewFile();
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Students");
        for(Student student : students){
            Row row = sheet.createRow(sheet.getLastRowNum()+ 1);
            row.createCell(0).setCellValue(student.getId());
            row.createCell(1).setCellValue(student.getName());
            row.createCell(2).setCellValue(student.getPhoneNumber());
        }
        workbook.write(new FileOutputStream(file));
        return ResponseDto.builder().code(2).success(true).message(file.getPath()).build();
    }
}
