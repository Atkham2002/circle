package circle_group.homeworkStudent.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(generator = "student_seq")
    @SequenceGenerator(name = "student_seq",sequenceName = "student_id_seq",allocationSize = 1)
    private Integer id;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToMany(mappedBy = "student")
    private List<StudentHomework> homework;
}
