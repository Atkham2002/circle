package circle_group.homeworkStudent.service;

import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.dto.ValidatorDto;

import java.util.List;

public interface ValidatorService {
    List<ValidatorDto> validatorStudent(StudentDto studentDto);
}
