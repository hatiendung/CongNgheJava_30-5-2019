package com.javawebspringboot.education.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawebspringboot.education.model.CoursesGoal;
import com.javawebspringboot.education.model.LearningOutcome;
import com.javawebspringboot.education.model.User;
import com.javawebspringboot.education.model.UserLearningOutcome;
import com.javawebspringboot.education.model.UserSubjectCoursesGoal;
import com.javawebspringboot.education.repository.LearningOutcomeRepository;
import com.javawebspringboot.education.repository.SubjectRepository;
import com.javawebspringboot.education.repository.UserLearningOutcomeRepository;
import com.javawebspringboot.education.repository.UserRepository;
import com.javawebspringboot.education.repository.UserSubjectCoursesGoalRepository;
import com.javawebspringboot.education.service.UserLearningOutcomeService;
import com.javawebspringboot.education.utiles.TableScore;

@Service
@Transactional
public class UserLearningOutcomeServiceImpl implements UserLearningOutcomeService {

	@Autowired
	private LearningOutcomeRepository learningOutcomeRepository;

	@Autowired
	private UserLearningOutcomeRepository userLearningOutcomeRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserSubjectCoursesGoalRepository userSubjectCoursesGoalRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<UserLearningOutcome> findByUser(User user) {
		return userLearningOutcomeRepository.findByUser(user);
	}

	@Override
	public void updateLearningOutcome(List<TableScore> tableScores, Integer idSubject) {
		for (TableScore tableScore : tableScores) {
			// mssv <=> username
			String mssv = tableScore.getMaSV();
			User student = userRepository.findByUsername(mssv);
			List<UserLearningOutcome> userLearningOutcomeList = userLearningOutcomeRepository.findByUser(student);

			List<UserSubjectCoursesGoal> userSubjectCoursesGoalList = userSubjectCoursesGoalRepository
					.findByUserAndSubject(student, subjectRepository.findByIdSubject(idSubject));
			List<LearningOutcome> learningOutcomeList = learningOutcomeRepository.findAll();

			// lay tat ca cac LearningOutcome
			for (LearningOutcome learningOutcome : learningOutcomeList) {
				List<CoursesGoal> coursesGoalsList = learningOutcome.getCoursesGoalsList();
				// lay tung CoursesGoal thuoc LearningOutcome
				for (CoursesGoal coursesGoal : coursesGoalsList) {
					System.out.println("G NGOAI " + coursesGoal.getSign() + " id " + coursesGoal.getIdCoursesGoal());
					for (UserSubjectCoursesGoal userSubjectCoursesGoal : userSubjectCoursesGoalList) {
						System.out.println("abc d " + userSubjectCoursesGoal.getCoursesgoal().getIdCoursesGoal());

						// neu mon hoc doc du lieu co chua G nam trong LO thi...
						if (coursesGoal.getIdCoursesGoal()
								.equals(userSubjectCoursesGoal.getCoursesgoal().getIdCoursesGoal())) {
							System.out.println("G TRONG " + coursesGoal.getSign() + " id "
									+ userSubjectCoursesGoal.getCoursesgoal().getIdCoursesGoal());
							// mon hoc vua doc tu file excel co chua G
							// G nay dung de cap nhat gia tri cho LO
							// dua vao bang UserLearningOutcome
							for (UserLearningOutcome userLearningOutcome : userLearningOutcomeList) {
								// da ton tai LO
								// can update % dat duoc
								if (userLearningOutcome.getLearningoutcome().equals(learningOutcome)) {
									float phamTramLO = userLearningOutcome.getPercent();
									float phanTramG = userSubjectCoursesGoal.getPercent();
									userLearningOutcome.setPercent((phamTramLO + phanTramG) / 2);
									if ((phamTramLO + phanTramG) / 2 >= 50) {
										userLearningOutcome.setEvaluate("Đạt");
									} else {
										userLearningOutcome.setEvaluate("Chưa đạt");
									}
									userLearningOutcomeRepository.save(userLearningOutcome);
								} else {
									// Chua co LO nay, can tao LO moi va insert vao cho sinh vien
									// LO = G
									float phanTramL = userSubjectCoursesGoal.getPercent();
									String evaluate = "";
									if (phanTramL >= 50) {
										evaluate = "Đạt";
									} else {
										evaluate = "Chưa đạt";
									}
									UserLearningOutcome newUserLearningOutcome = new UserLearningOutcome(student,
											learningOutcome, phanTramL, evaluate);

									userLearningOutcomeRepository.save(newUserLearningOutcome);
								}
							}
						}
					}

				}
			}
		}

	}

}
