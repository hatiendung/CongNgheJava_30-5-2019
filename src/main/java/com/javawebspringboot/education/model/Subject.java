package com.javawebspringboot.education.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject")

public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_monhoc")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSubject;

	@Column(name = "ten_monhoc")
	private String nameSubject;

	@Column(name = "code_subject")
	private String codeSubject;

	@Column(name = "tg_batdau")
	private Date startTime;

	@Column(name = "tg_ketthuc")
	private Date finishTime;

	@Column(name = "so_tin_chi")
	private Integer numberOfCredits;

	@ManyToMany(mappedBy = "subjects")
	private List<User> users;

	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
	private List<CoursesGoal> coursesGoals;

	@OneToMany(mappedBy = "monhoc", fetch = FetchType.LAZY)
	private List<Scores> scoresList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subject", fetch = FetchType.LAZY)
	private List<UserSubjectCoursesGoal> userSubjectCoursesgoalList;

	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
	private List<Answer> answerList;

	public Subject() {
		super();
	}

	public Subject(String nameSubject, String codeSubject, Date startTime, Date finishTime, Integer numberOfCredits,
			List<User> users, List<CoursesGoal> coursesGoals, List<Scores> scoresList,
			List<UserSubjectCoursesGoal> userSubjectCoursesgoalList, List<Answer> answerList) {
		super();
		this.nameSubject = nameSubject;
		this.codeSubject = codeSubject;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.numberOfCredits = numberOfCredits;
		this.users = users;
		this.coursesGoals = coursesGoals;
		this.scoresList = scoresList;
		this.userSubjectCoursesgoalList = userSubjectCoursesgoalList;
		this.answerList = answerList;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	public Integer getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(Integer idSubject) {
		this.idSubject = idSubject;
	}

	public String getNameSubject() {
		return nameSubject;
	}

	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}

	public String getCodeSubject() {
		return codeSubject;
	}

	public void setCodeSubject(String codeSubject) {
		this.codeSubject = codeSubject;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getNumberOfCredits() {
		return numberOfCredits;
	}

	public void setNumberOfCredits(Integer numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<CoursesGoal> getCoursesGoals() {
		return coursesGoals;
	}

	public void setCoursesGoals(List<CoursesGoal> coursesGoals) {
		this.coursesGoals = coursesGoals;
	}

	public List<Scores> getScoresList() {
		return scoresList;
	}

	public void setScoresList(List<Scores> scoresList) {
		this.scoresList = scoresList;
	}

	public List<UserSubjectCoursesGoal> getUserSubjectCoursesgoalList() {
		return userSubjectCoursesgoalList;
	}

	public void setUserSubjectCoursesgoalList(List<UserSubjectCoursesGoal> userSubjectCoursesgoalList) {
		this.userSubjectCoursesgoalList = userSubjectCoursesgoalList;
	}

}
