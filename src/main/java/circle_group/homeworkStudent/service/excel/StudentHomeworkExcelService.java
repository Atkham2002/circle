package circle_group.homeworkStudent.service.excel;

import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import circle_group.homeworkStudent.dto.TaskDto;

import java.util.List;

public interface StudentHomeworkExcelService {

    String writeEntityToExcel(List<StudentHomeworkDto> list, List<StudentDto> studentDtoList, List<TaskDto> taskDtoList);
}
