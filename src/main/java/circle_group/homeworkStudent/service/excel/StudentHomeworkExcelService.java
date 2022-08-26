package circle_group.homeworkStudent.service.excel;

import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import circle_group.homeworkStudent.dto.TaskDto;
import circle_group.homeworkStudent.my_model.MultiDomain;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

public interface StudentHomeworkExcelService {

    void writeEntityToExcel(HashMap<StudentDto, List<MultiDomain>> map, List<TaskDto> taskDtoList, HttpServletResponse response);
}
