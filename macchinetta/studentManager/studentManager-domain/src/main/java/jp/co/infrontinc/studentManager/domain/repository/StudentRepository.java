package jp.co.infrontinc.studentManager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.infrontinc.studentManager.domain.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
