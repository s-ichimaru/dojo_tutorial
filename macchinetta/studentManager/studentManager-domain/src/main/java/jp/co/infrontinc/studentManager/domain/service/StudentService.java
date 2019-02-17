package jp.co.infrontinc.studentManager.domain.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.infrontinc.studentManager.domain.model.Student;
import jp.co.infrontinc.studentManager.domain.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

	@Inject
	private StudentRepository studentRepository;

	public void create(Student student) {

		student.setStudentId(1104);
		studentRepository.save(student);

		student.setStudentId(1105);
		studentRepository.save(student);

		throw new RuntimeException();

/*
		EntityManager testManager = entityManager.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = testManager.getTransaction();

		transaction.begin();


		student.setStudentId(1000);

		testManager.persist(student);


//		studentRepository.save(student);

		Student studentSub = studentRepository.findOne(1002);
		System.out.println(studentSub);

		transaction.commit();
*/
	}
}
