package circle_group.homeworkStudent.my_model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MultiDomain {

    private int id;

    private String name;

    private String phoneNumber;

    private String body;

    private String comment;

    private int overall;
}
