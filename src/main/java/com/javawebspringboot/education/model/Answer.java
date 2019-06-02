package com.javawebspringboot.education.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_answer")
	private Integer idAnswer;
	@Column(name = "stt_answer")
	private Integer sttAnswer;
	@Column(name = "id_kithi")
	private Integer idKithi;

	@JoinColumn(name = "id_subject", referencedColumnName = "id_monhoc")
	@ManyToOne(fetch = FetchType.LAZY)
	private Subject subject;

	@JoinTable(name = "answer_coursesgoal", joinColumns = {
			@JoinColumn(name = "id_answer", referencedColumnName = "id_answer") },
			inverseJoinColumns = {
					@JoinColumn(name = "id_coursesgoal", referencedColumnName = "id_course_goal") })
	@ManyToMany(fetch = FetchType.LAZY)
	private List<CoursesGoal> coursesGoalList;

	public Answer() {
	}

	public Answer(Integer sttAnswer, Integer idKithi, Subject subject, List<CoursesGoal> coursesGoalList) {
		super();
		this.sttAnswer = sttAnswer;
		this.idKithi = idKithi;
		this.subject = subject;
		this.coursesGoalList = coursesGoalList;
	}

	public Integer getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(Integer idAnswer) {
		this.idAnswer = idAnswer;
	}

	public Integer getSttAnswer() {
		return sttAnswer;
	}

	public void setSttAnswer(Integer sttAnswer) {
		this.sttAnswer = sttAnswer;
	}

	public Integer getIdKithi() {
		return idKithi;
	}

	public void setIdKithi(Integer idKithi) {
		this.idKithi = idKithi;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<CoursesGoal> getCoursesGoalList() {
		return coursesGoalList;
	}

	public void setCoursesGoalList(List<CoursesGoal> coursesGoalList) {
		this.coursesGoalList = coursesGoalList;
	}

}
