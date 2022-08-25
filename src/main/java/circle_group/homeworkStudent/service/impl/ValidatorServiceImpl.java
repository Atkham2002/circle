package circle_group.homeworkStudent.service.impl;

import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.dto.ValidatorDto;
import circle_group.homeworkStudent.service.ValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ValidatorServiceImpl implements ValidatorService {
    @Override
    public List<ValidatorDto> validatorStudent(StudentDto studentDto) {
        List<ValidatorDto> errors = new  ArrayList();
        if(!StringUtils.hasText(studentDto.getName())){
            errors.add(new ValidatorDto("name","Bo'sh maydon"));
        }
        if(studentDto.getPhoneNumber() == null){
            errors.add(new ValidatorDto("phoneNumber","Bo'sh maydon"));
        }
        if(studentDto.getPhoneNumber().length()  <= 12 || !studentDto.getPhoneNumber().startsWith("+")){
            errors.add(new ValidatorDto("phoneNumber","phoneNumber Natog'ri  M:+998 91 1234567"));
        }
        return errors;

    }
}
