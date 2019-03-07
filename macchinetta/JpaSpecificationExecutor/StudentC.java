package jp.co.infrontinc.studentManager.domain.student.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import lombok.Data;

@Data
public class StudentC implements Serializable {

	private String studentName;

	private String perfCd;

    public Specification<Student> studentNameLike() {
        return StringUtils.isEmpty(studentName) ? null : (root, query, cb) -> {
            return cb.like(root.get("studentName"), "%" + studentName + "%");
        };
    }

    public Specification<Student> perfCdEqual() {
        return StringUtils.isEmpty(perfCd) ? null : (root, query, cb) -> {
            return  cb.equal(root.get("perfCd"), perfCd);
        };
    }

}
