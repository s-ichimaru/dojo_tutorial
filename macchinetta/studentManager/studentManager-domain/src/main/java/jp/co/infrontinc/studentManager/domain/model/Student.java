package jp.co.infrontinc.studentManager.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_student")
public class Student {

	@Id
//	@GeneratedValue
	@Column(name="student_id")
	private int studentId;

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", perfId=" + perfId + ", age="
				+ age + ", birthday=" + birthday + "]";
	}

	@Column(name="student_name")
	private String studentName;

	@Column(name="perf_id")
	private int perfId;

	@Column
	private int age;

	@Column
	private Date birthday;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getPerfId() {
		return perfId;
	}

	public void setPerfId(int perfId) {
		this.perfId = perfId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
