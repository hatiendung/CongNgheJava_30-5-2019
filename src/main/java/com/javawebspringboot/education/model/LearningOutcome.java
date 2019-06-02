package com.javawebspringboot.education.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "learningoutcome")
public class LearningOutcome implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_chuandaura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLearningOutcome;

	@Column(name = "kihieu")
	private String kiHieu;

	@Column(name = "tenchuandaura")
	private String tenChuanDauRa;

	@OneToMany(mappedBy = "learningoutcome", fetch = FetchType.LAZY)
	private List<UserLearningOutcome> userLearningoutcomeList;

	@ManyToMany
	@JoinTable(name = "coursesgoal_learningoutcome", joinColumns = @JoinColumn(name = "id_learning_outcome", referencedColumnName = "id_chuandaura"), 
		inverseJoinColumns = @JoinColumn(name = "id_courses_goal", referencedColumnName = "id_course_goal"))
	private List<CoursesGoal> coursesGoalsList;
	
	public LearningOutcome() {
		super();
	}

	public LearningOutcome(String kiHieu, String tenChuanDauRa, List<UserLearningOutcome> userLearningoutcomeList,
			List<CoursesGoal> coursesGoalsList) {
		super();
		this.kiHieu = kiHieu;
		this.tenChuanDauRa = tenChuanDauRa;
		this.userLearningoutcomeList = userLearningoutcomeList;
		this.coursesGoalsList = coursesGoalsList;
	}

	public List<CoursesGoal> getCoursesGoalsList() {
		return coursesGoalsList;
	}

	public void setCoursesGoalsList(List<CoursesGoal> coursesGoalsList) {
		this.coursesGoalsList = coursesGoalsList;
	}

	public List<UserLearningOutcome> getUserLearningoutcomeList() {
		return userLearningoutcomeList;
	}

	public void setUserLearningoutcomeList(List<UserLearningOutcome> userLearningoutcomeList) {
		this.userLearningoutcomeList = userLearningoutcomeList;
	}

	public Integer getIdLearningOutcome() {
		return idLearningOutcome;
	}

	public void setIdLearningOutcome(Integer idLearningOutcome) {
		this.idLearningOutcome = idLearningOutcome;
	}

	public String getKiHieu() {
		return kiHieu;
	}

	public void setKiHieu(String kiHieu) {
		this.kiHieu = kiHieu;
	}

	public String getTenChuanDauRa() {
		return tenChuanDauRa;
	}

	public void setTenChuanDauRa(String tenChuanDauRa) {
		this.tenChuanDauRa = tenChuanDauRa;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getTenChuanDauRa();
	}

}
