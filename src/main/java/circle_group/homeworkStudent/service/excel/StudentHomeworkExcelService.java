package circle_group.homeworkStudent.service.excel;

import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import circle_group.homeworkStudent.dto.TaskDto;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface StudentHomeworkExcelService {

    void writeEntityToExcel(List<StudentHomeworkDto> list, List<StudentDto> studentDtoList, List<TaskDto> taskDtoList, HttpServletResponse response) throws IOException;
}
