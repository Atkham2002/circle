package circle_group.homeworkStudent.service.excel.impl;

import circle_group.homeworkStudent.dto.StudentDto;
import circle_group.homeworkStudent.dto.TaskDto;
import circle_group.homeworkStudent.my_model.MultiDomain;
import circle_group.homeworkStudent.service.excel.StudentHomeworkExcelService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class StudentHomeworkExcelServiceImpl implements StudentHomeworkExcelService {


    @Override
    public void writeEntityToExcel(HashMap<StudentDto, List<MultiDomain>> map, List<TaskDto> taskDtoList, HttpServletResponse response) {
        Set<Map.Entry<StudentDto, List<MultiDomain>>> set = map.entrySet();
        Set<StudentDto> studentDtoList = map.keySet();

        XSSFWorkbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Student results");

        Row row = sheet.createRow(0);

        row.createCell(0).setCellValue("O'quvchi ismi");
        row.createCell(1).setCellValue("O'quvchi tel.");
        int j = 2;
        for(int i = 0; i < taskDtoList.size(); i++){
            row.createCell(j++).setCellValue((i + 1) + "-vazifa");
            row.createCell(j++).setCellValue((i + 1) + "v izoh");
        }
        for (Map.Entry<StudentDto, List<MultiDomain>> entries: set){
            StudentDto studentDto = entries.getKey();

            Row r = sheet.createRow(sheet.getLastRowNum() + 1);
            r.createCell(0).setCellValue(studentDto.getName());
            r.createCell(1).setCellValue(studentDto.getPhoneNumber());

            int columnNum = 2;
            for (MultiDomain domains: entries.getValue()){
                r.createCell(columnNum++).setCellValue(domains.getBody());
                r.createCell(columnNum++).setCellValue(domains.getOverall());
            }

        }

        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; fileName=\"student_results.xlsx\"");

            workbook.write(response.getOutputStream());
            workbook.close();
            response.getOutputStream().close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
