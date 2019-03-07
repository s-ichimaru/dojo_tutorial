package jp.co.infrontinc.studentManager.domain.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import jp.co.infrontinc.studentManager.domain.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {

//	Page<Student> findByCriteria(StudentC studentC, Pageable pageable);

}
