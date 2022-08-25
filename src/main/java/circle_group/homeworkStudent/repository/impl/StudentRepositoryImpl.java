package circle_group.homeworkStudent.repository.impl;

import circle_group.homeworkStudent.entity.Student;
import lombok.RequiredArgsConstructor;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableFunction;
import org.apache.poi.hssf.record.MulBlankRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryImpl {
    private final EntityManager entityManager;
    public Page<Student> findByParms(PageRequest pageRequest , MultiValueMap<String,String> params){
        StringBuilder queryParams = new StringBuilder();
        String queryStr = "SELECT  * from student s where 1=1" + queryParams;
        String countStr = "SELECT  COUNT(1) form student where 1=1 " + queryParams;
        queryBuilder(params,queryParams);
        Query query = entityManager.createNativeQuery(queryStr,Student.class);
        Query countQuery = entityManager.createNativeQuery(countStr,Integer.class);
        setParameter(params,query);
        setParameter(params,countQuery);

        if(pageRequest !=null){
            query.setFirstResult(pageRequest.getPageSize() * pageRequest.getPageNumber());
            query.setMaxResults(pageRequest.getPageSize());
        }
        Integer count = countQuery.getFirstResult();
        List<Student>  res = query.getResultList();
        return new PageImpl<>(res,pageRequest,count);
    }
    private void queryBuilder(MultiValueMap<String,String> params,StringBuilder builder){
        if(params.containsKey("name")){
            builder.append(" AND s.name =:name");
        }
        if(params.containsKey("phoneNumber")){
            builder.append(" AND s.phoneNumber =: phoneNumber");
        }

    }
    private void setParameter(MultiValueMap<String,String> params , Query query){
        if(params.containsKey("name")) {
            query.setParameter("name",params.getFirst("name"));
        }
        if(params.containsKey("phoneNumber")){
            query.setParameter("phoneNumber",params.getFirst("phoneNumber"));
        }
    }

}
