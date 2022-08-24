package circle_group.homeworkStudent.service.mapper.impl;
import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.entity.Student;


public class StudentMapperHM {

    public static Student toEntityNull(StudentDto studentDto){
        return Student.builder()
                .id(studentDto.getId())
                .name(studentDto.getName())
                .phoneNumber(studentDto.getPhoneNumber())
                .build();
    }
    public static StudentDto toDtoNull(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .phoneNumber(student.getPhoneNumber())
                .build();
    }
}
