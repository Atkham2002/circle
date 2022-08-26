package circle_group.homeworkStudent.repository.helper;

import circle_group.homeworkStudent.entity.helper.StudentHomeworkResult;
import circle_group.homeworkStudent.my_model.MultiDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentHomeworkQH {

    private final EntityManager manager;

    public List<MultiDomain> returnPerfectAnswer(){
        Query query = manager
                .createNativeQuery(
                "SELECT sh.id, s.name, s.phone_number, t.body, t.comment, " +
                        "sh.overall FROM student_homework sh join student s on " +
                        "sh.student_id = s.id join task t on t.id=sh.task_id");
//"SELECT sh.id, s.name, s.phoneNumber, t.body, t.comment, sh.overall FROM StudentHomework sh join fetch Student s join fetch Task t"

        List<Object[]> resultList = query.getResultList();
        List<MultiDomain> multiDomains = new ArrayList<>();
        for(Object[] o: resultList){
            MultiDomain domain = MultiDomain.builder()
                    .id((int) o[0]).name(o[1]+"").phoneNumber(o[2]+"").body(o[3]+"").comment(o[4]+"").overall((int)o[5]).build();
            multiDomains.add(domain);
        }

        return multiDomains;
    }
}
