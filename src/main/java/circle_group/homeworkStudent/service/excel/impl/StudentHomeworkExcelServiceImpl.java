package circle_group.homeworkStudent.service.excel.impl;

import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.dto.StudentHomeworkDto;
import circle_group.homeworkStudent.dto.TaskDto;
import circle_group.homeworkStudent.entity.Student;
import circle_group.homeworkStudent.service.excel.StudentHomeworkExcelService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class StudentHomeworkExcelServiceImpl implements StudentHomeworkExcelService {


    @Override
    public String writeEntityToExcel(List<StudentHomeworkDto> list, List<StudentDto> studentDtoList, List<TaskDto> taskDtoList) {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Uyga vazifalar");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("O`quvchi ismi");
        header.createCell(2).setCellValue("O`quvchi telefon raqami");

        for (int i = 3; i < taskDtoList.size(); i++) {
            header.createCell(i).setCellValue("Vazifa-" + i);
            header.createCell(i).setCellValue("Izoh-" + i + "V");
        }



        return null;
    }
}
