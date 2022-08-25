package circle_group.homeworkStudent.my_model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class StudentScores {

    private Integer id;

    private String name;

    private String phoneNumber;

    private Map<Integer, Task> scores;

    @Data
    @Builder
    static class Task{
        private Integer taskId;

        private String taskBody;

        private Integer overall;
    }
}
