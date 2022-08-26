package circle_group.homeworkStudent.beans;

import circle_group.homeworkStudent.my_model.StudentScores;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SmallConfigs {

    @Bean
    public List<StudentScores> returnStudentScoresList(){
        return new ArrayList<>();
    }
}
