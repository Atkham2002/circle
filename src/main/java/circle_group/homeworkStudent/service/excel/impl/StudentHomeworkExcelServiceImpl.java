package circle_group.homeworkStudent.service.excel.impl;

import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import circle_group.homeworkStudent.dto.TaskDto;
import circle_group.homeworkStudent.service.excel.StudentHomeworkExcelService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class StudentHomeworkExcelServiceImpl implements StudentHomeworkExcelService {



    @Override
    public void writeEntityToExcel(List<StudentHomeworkDto> list, List<StudentDto> studentDtoList, List<TaskDto> taskDtoList, HttpServletResponse response) throws IOException {
        Workbook workbook = new XSSFWorkbook(getClass().getClassLoader().getResource("templates/Students.xlsx").openStream());

        Sheet sheet = workbook.createSheet("Uyga vazifalar");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("O`quvchi ismi");
        header.createCell(2).setCellValue("O`quvchi telefon raqami");

        int rowNum = sheet.getLastRowNum();

        for (int i = rowNum; i < taskDtoList.size(); i++) {
            header = sheet.createRow(i++);
            header.createCell(i).setCellValue("Vazifa-" + i);
            header.createCell(i).setCellValue("Izoh-" + i + "V");
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition","attachment; filename =\"studentsHomework.xlsx\"");

        workbook.write(response.getOutputStream());
        workbook.close();
        response.getOutputStream().close();

    }
}
