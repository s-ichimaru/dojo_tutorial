package jp.co.infrontinc.studentManager.domain.student.service;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.infrontinc.studentManager.domain.student.model.Student;
import jp.co.infrontinc.studentManager.domain.student.model.StudentC;
import jp.co.infrontinc.studentManager.domain.student.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	//    @PersistenceContext
	//    EntityManager entityManager;

	@Inject
	private StudentRepository studentRepository;

	public void create(Student student) {
		studentRepository.save(student);
	}

	public void update(Student student) {
		studentRepository.save(student);
	}

	public void delete(Integer studentId) {
		studentRepository.delete(studentId);
	}

	public Student findOne(Integer studentId) {
		return studentRepository.findOne(studentId);
	}

	public Page<Student> findByCriteria(StudentC studentC, Pageable pageable) {

		pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(),
				new Sort(Direction.ASC, "studentId"));

		return studentRepository.findAll(
				Specifications
					.where(studentC.studentNameLike())
					.and(studentC.perfCdEqual())
				, pageable);
	}

/*
	public Page<Student> findByCriteria(StudentC studentC, Pageable pageable) {

		Student findStudent = new Student();

		if (StringUtils.isNotEmpty(studentC.getStudentName())) {
			findStudent.setStudentName(studentC.getStudentName());
		}
		if (StringUtils.isNotEmpty(studentC.getPerfCd())) {
			findStudent.setPerfCd(studentC.getPerfCd());
		}

		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("studentName", match -> match.startsWith());

		Example<Student> example = Example.of(findStudent, matcher);

		pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(),
				new Sort(Direction.ASC, "studentId"));

		return studentRepository.findAll(example, pageable);
	}
*/
}

/*
EntityManager testManager = entityManager.getEntityManagerFactory().createEntityManager();
EntityTransaction transaction = testManager.getTransaction();

transaction.begin();


student.setStudentId(1000);

testManager.persist(student);


//studentRepository.save(student);

Student studentSub = studentRepository.findOne(1002);
System.out.println(studentSub);

transaction.commit();
*/
