package com.javawebspringboot.education.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javawebspringboot.education.exception.ReadFileException;
import com.javawebspringboot.education.model.Answer;
import com.javawebspringboot.education.model.CoursesGoal;
import com.javawebspringboot.education.model.LearningOutcome;
import com.javawebspringboot.education.model.Scores;
import com.javawebspringboot.education.model.Subject;
import com.javawebspringboot.education.model.User;
import com.javawebspringboot.education.model.UserLearningOutcome;
import com.javawebspringboot.education.model.UserSubjectCoursesGoal;
import com.javawebspringboot.education.repository.AnswerRepository;
import com.javawebspringboot.education.repository.ScoresRepository;
import com.javawebspringboot.education.repository.SubjectRepository;
import com.javawebspringboot.education.repository.UserLearningOutcomeRepository;
import com.javawebspringboot.education.repository.UserRepository;
import com.javawebspringboot.education.repository.UserSubjectCoursesGoalRepository;
import com.javawebspringboot.education.service.SubjectService;
import com.javawebspringboot.education.utiles.TableScore;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoresRepository scoresRepository;

	@Autowired
	private UserSubjectCoursesGoalRepository userSubjectCoursesGoalRepository;

	@Autowired
	private UserLearningOutcomeRepository userLearningOutcomeRepository;

	@Override
	public List<TableScore> fileHandler(MultipartFile fileExcel) throws ReadFileException {
		Workbook workbook;
		List<TableScore> listTableScore = new ArrayList<TableScore>();

		String lowerCaseFileName = fileExcel.getOriginalFilename().toLowerCase();
		if (lowerCaseFileName.endsWith(".xlsx")) {
			try {
				workbook = new XSSFWorkbook(fileExcel.getInputStream());
				Sheet sheet = workbook.getSheetAt(0);

				Iterator<Row> rowIterator = sheet.iterator();
				if (rowIterator.hasNext()) {
					// bo qua dong dau tien trong bang
					// title cua bang
					rowIterator.next();
					// bat dau duyet tu dong thu 2 de lay du lieu
					while (rowIterator.hasNext()) {
						Row row = rowIterator.next();
						Iterator<Cell> cellIterator = row.cellIterator();
						// tao ra moi doi tuong TableScore de luu tung row

						TableScore tableScore = new TableScore();
						List<Float> diems = new ArrayList<Float>();

						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							int columnIndex = cell.getColumnIndex();

							// STT trong bang
							if (columnIndex == 0) {
								// bo qua khong lam gi het
							}

							// ma so sinh vien
							if (columnIndex == 1) {
								String mssv = cell.getStringCellValue();
								tableScore.setMaSV(mssv);
							}

							// ho ten sinh vien
							if (columnIndex == 2) {
								String hoTen = cell.getStringCellValue();
								tableScore.setTenSV(hoTen);
							}
							if (columnIndex > 2) {
								if (cell.getCellType() == Cell.CELL_TYPE_STRING || cell.getNumericCellValue() > 10
										|| cell.getNumericCellValue() < 0) {

									String msg = getErrorMsg(row);
									ReadFileException.messageError(msg);
									throw new ReadFileException();
								}

								double diem = cell.getNumericCellValue();
								float d = (float) diem;
								diems.add(d);

							}
						}
						tableScore.setDsDiem(diems);
						listTableScore.add(tableScore);

					}
				}

			} catch (IOException e) {

				return null;
			}
		} else if (lowerCaseFileName.endsWith(".xls")) {
			try {
				workbook = new HSSFWorkbook(fileExcel.getInputStream());
				Sheet sheet = workbook.getSheetAt(0);

				Iterator<Row> rowIterator = sheet.iterator();
				if (rowIterator.hasNext()) {
					// bo qua dong dau tien trong bang
					// title cua bang
					rowIterator.next();
					// bat dau duyet tu dong thu 2 de lay du lieu
					while (rowIterator.hasNext()) {
						Row row = rowIterator.next();
						Iterator<Cell> cellIterator = row.cellIterator();
						// tao ra moi doi tuong TableScore de luu tung row

						TableScore tableScore = new TableScore();
						List<Float> diems = new ArrayList<Float>();

						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							int columnIndex = cell.getColumnIndex();

							// STT trong bang
							if (columnIndex == 0) {
								// bo qua khong lam gi het
							}

							// ma so sinh vien
							if (columnIndex == 1) {
								String mssv = cell.getStringCellValue();
								tableScore.setMaSV(mssv);
							}

							// ho ten sinh vien
							if (columnIndex == 2) {
								String hoTen = cell.getStringCellValue();
								tableScore.setTenSV(hoTen);
							}
							if (columnIndex > 2) {
								if (cell.getCellType() == Cell.CELL_TYPE_STRING || cell.getNumericCellValue() > 10
										|| cell.getNumericCellValue() < 0) {

									String msg = getErrorMsg(row);
									ReadFileException.messageError(msg);
									throw new ReadFileException();
								}

								double diem = cell.getNumericCellValue();
								float d = (float) diem;
								diems.add(d);

							}
						}
						tableScore.setDsDiem(diems);
						listTableScore.add(tableScore);

					}
				}

			} catch (IOException e) {

				return null;
			}
		}

		return listTableScore;
	}

	@Override
	public Subject findByIdSubject(Integer idSubject) {

		return subjectRepository.findByIdSubject(idSubject);
	}

	private String getErrorMsg(Row row) {

		String strError = "";
		Iterator<Cell> cellIterator1 = row.cellIterator();
		while (cellIterator1.hasNext()) {

			Cell c = cellIterator1.next();
			if (c.getCellType() == Cell.CELL_TYPE_STRING) {
				String value = c.getStringCellValue();
				strError += value + " ";
			}
			if (c.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				double val = c.getNumericCellValue();
				if (c.getColumnIndex() == 0) {
					strError += (int) val + " ";
					continue;
				}
				strError += String.valueOf(val) + " ";

			}
		}
		return strError;

	}

	@Override
	public void readData(List<TableScore> listTableScore, Integer idSubject, String cotDiem) {
		// 1 mon hoc chi co nhieu nhat 4 cot diem chinh
		// vi the khi client truyen len chuoi -> ma cot diem
		int idCotDiem = getIdCotDiem(cotDiem);
		Subject subject = subjectRepository.findByIdSubject(idSubject);

		// lay du lieu bang anwer de biet duoc cau hoi nao, cua mon hoc nay, ung voi ki
		// thi nay
		// thi cau hoi nay se co nhung chuan dau ra mon hoc tuong ung thong qua
		// hibernate

		// vi du: cau hoi 1, mon cong nghe java, ki thi giua ki
		// se co cac chuan G1, G3,G4,...

		List<Answer> answerList = answerRepository.findBySubjectAndIdKithiOrderBySttAnswer(subject, idCotDiem);

		// tao Map chua key la CoursesGoal va value la %G dat duoc
		Map<CoursesGoal, Float> coursesGoalMap = new HashMap<>();
		for (Answer answer : answerList) {
			for (CoursesGoal cg : answer.getCoursesGoalList()) {
				coursesGoalMap.put(cg, null);
			}

		}
		Set<CoursesGoal> coursesGoalsSet = coursesGoalMap.keySet();

		// tung dong du lieu trong table da duoc luu tru trong listTableScore
		// lap tung phan tu trong listTableScore <=> lay dong trong table
		// listTableScore duoc luu tru nhu sau
		// maSV | tenSV | diem cau 1| diem cau 2 | diem cau 3 | ....| diem tong

		for (TableScore score : listTableScore) {
			String maSV = score.getMaSV();
			User sinhVien = userRepository.findByUsername(maSV);
			// co the co nhung G ton tai trong nhieu cot diem
			// vi the phai lay % G dat duoc so tinh tiep
			List<UserSubjectCoursesGoal> userSubjectCoursesGoals = userSubjectCoursesGoalRepository
					.findByUserAndSubject(sinhVien, subject);

			// lay %G da dat duoc
			// can thiet khi trong ki thi khac co cung G voi ki thi hien tai
			if (!userSubjectCoursesGoals.isEmpty()) {
				for (UserSubjectCoursesGoal uscg : userSubjectCoursesGoals) {
					for (CoursesGoal coursesGoal : coursesGoalsSet) {
						if (coursesGoal.equals(uscg.getCoursesgoal())) {
							float tranPhanDaDatDuoc = uscg.getPercent();
							coursesGoalMap.put(coursesGoal, tranPhanDaDatDuoc);
						}
					}
				}
			}

			// tong so cot diem tu cau 1 , cau 2 ... -> diem tong
			int tongCotDiem = score.getDsDiem().size();
			for (int i = 0; i < tongCotDiem; i++) {
				if ((i < tongCotDiem - 1) && (i == answerList.get(i).getSttAnswer() - 1)) {
					// diem tung cau hoi
					// lay cot diem thu i trong bang
					float diem = score.getDsDiem().get(i);

					float diem1Cau = (float) (10.0 / (tongCotDiem - 1));
					float phanTramG = (diem / diem1Cau) * 100;
					// lay cac G cua cau hoi i
					for (int j = 0; j < answerList.get(i).getCoursesGoalList().size(); j++) {
						// lay ra cau hoi thu i co Gj
						// cau hoi j co G_j+1
						CoursesGoal coursesGoal = answerList.get(i).getCoursesGoalList().get(j);
						if (coursesGoalMap.get(coursesGoal) == null) {
							coursesGoalMap.put(coursesGoal, phanTramG);

						} else {
							coursesGoalMap.put(coursesGoal, (coursesGoalMap.get(coursesGoal) + phanTramG) / 2);
						}
					}

				} else {
					// diem tong
					// luu diem cho sinh vien
					float diemTong = score.getDsDiem().get(i);
					// saveTableScore(sinhVien, subject, idCotDiem, diemTong);

				}

			}

			// luu nhung G ma sinh vien nay dat duoc
			saveCourseGoal(coursesGoalMap, sinhVien, subject);

		}

	}

	private void saveCourseGoal(Map<CoursesGoal, Float> coursesGoalMap, User sinhVien, Subject subject) {

		List<UserSubjectCoursesGoal> userSubjectCoursesGoals = userSubjectCoursesGoalRepository
				.findByUserAndSubject(sinhVien, subject);
		Set<CoursesGoal> coursesGoalsSetG = coursesGoalMap.keySet();
		Set<CoursesGoal> coursesGoalsSetLO = coursesGoalMap.keySet();
		// luu G
		// saveCouseGoalToDatabase(coursesGoalMap, userSubjectCoursesGoals,
		// coursesGoalsSetG, sinhVien, subject);
		// sau khi luu G xong thi ta phai xu li luon ca LO lien quan den cac G

		saveLearningOutcomeToDatatase(coursesGoalMap, sinhVien, coursesGoalsSetLO);

	}

	private void saveLearningOutcomeToDatatase(Map<CoursesGoal, Float> coursesGoalMap, User sinhVien,
			Set<CoursesGoal> coursesGoalsSetLO) {

		// tim cac user nam trong userLearningOutcomeRepository de update LO
		List<UserLearningOutcome> userLearningOutcomeList = userLearningOutcomeRepository.findByUser(sinhVien);

		// update LO
		System.out.println("coursesGoalsSetLO " + coursesGoalsSetLO.size());
		if (!userLearningOutcomeList.isEmpty()) {
			for (CoursesGoal coursesGoal : coursesGoalsSetLO) {

				// tim user da dat LO nao de update %LO them
				for (UserLearningOutcome userLearningOutcome : userLearningOutcomeList) {
					for (LearningOutcome learningOutcome : coursesGoal.getLearningOutcomeList()) {
						if (userLearningOutcome.getLearningoutcome().equals(learningOutcome)) {
							// lay phan %LO cu
							float oldPercent = 0;
							try {
								oldPercent = userLearningOutcome.getPercent();
							} catch (Exception e) {
								oldPercent = 0;
							}
							float newPercent = coursesGoalMap.get(coursesGoal);
							float percent = (oldPercent + newPercent) / 2;
							String value = "";
							if (percent >= 50) {
								value = "Đạt";
							} else {
								value = "Chưa đạt";
							}
							userLearningOutcome.setEvaluate(value);
							userLearningOutcome.setPercent(percent);

							// remove CoursesGoal da duoc update khoi Set de bi trung voi cac LO sau nay
							coursesGoalsSetLO.remove(coursesGoal);
							break;

						}
					}
				}

			}
		}

		// THEM MOI LO
		if (!coursesGoalsSetLO.isEmpty()) {
			for (CoursesGoal coursesGoal : coursesGoalsSetLO) {
				for (LearningOutcome learningOutcome : coursesGoal.getLearningOutcomeList()) {
					Float percent = coursesGoalMap.get(coursesGoal);
					String value = "";
					if (percent >= 50) {
						value = "Đạt";
					} else {
						value = "Chưa đạt";
					}

					UserLearningOutcome userLearningOutcome = new UserLearningOutcome(sinhVien, learningOutcome,
							percent, value);
					userLearningOutcomeList.add(userLearningOutcome);
				}
			}
		}
		// LUU TUNG UserLearningOutcome trong userLearningOutcomeList VAO CSDL
		for (UserLearningOutcome userLearningOutcome : userLearningOutcomeList) {
			if (userLearningOutcome != null) {
				System.out.println("asdf");
				userLearningOutcomeRepository.save(userLearningOutcome);
			} else {
				System.out.println("null");
			}

		}

	}

	private void saveCouseGoalToDatabase(Map<CoursesGoal, Float> coursesGoalMap,
			List<UserSubjectCoursesGoal> userSubjectCoursesGoals, Set<CoursesGoal> coursesGoalsSet, User sinhVien,
			Subject subject) {

		if (userSubjectCoursesGoals.isEmpty()) {
			userSubjectCoursesGoals = new ArrayList<UserSubjectCoursesGoal>();
			for (CoursesGoal coursesGoal : coursesGoalsSet) {
				UserSubjectCoursesGoal userSubjectCoursesGoal = new UserSubjectCoursesGoal();
				userSubjectCoursesGoal.setCoursesgoal(coursesGoal);
				userSubjectCoursesGoal.setUser(sinhVien);
				userSubjectCoursesGoal.setSubject(subject);
				float percent = coursesGoalMap.get(coursesGoal);
				userSubjectCoursesGoal.setPercent(percent);
				if (percent >= 50) {
					userSubjectCoursesGoal.setEvaluate("Đạt");
				} else {
					userSubjectCoursesGoal.setEvaluate("Chưa đạt");
				}
				userSubjectCoursesGoals.add(userSubjectCoursesGoal);

			}
		} else {
			// cap nhat nhung cai da co va them nhung cai chua co

			// cap nhat cai da co
			for (int i = 0; i < userSubjectCoursesGoals.size(); i++) {
				for (CoursesGoal coursesGoal : coursesGoalsSet) {
					if (coursesGoal.equals(userSubjectCoursesGoals.get(i).getCoursesgoal())) {
						float percent = coursesGoalMap.get(coursesGoal);
						String evaluate = "";
						if (percent >= 50) {
							evaluate = "Đạt";
						} else {
							evaluate = "Chưa đạt";
						}

						UserSubjectCoursesGoal userUpdate = userSubjectCoursesGoals.get(i);
						userUpdate.setUser(sinhVien);
						userUpdate.setSubject(subject);
						userUpdate.setCoursesgoal(coursesGoal);
						userUpdate.setPercent(percent);
						userUpdate.setEvaluate(evaluate);
						userSubjectCoursesGoals.set(i, userUpdate);
						coursesGoalsSet.remove(coursesGoal);
						coursesGoalMap.remove(coursesGoal);
					}
				}
			}

			// them cai chua co
			if (!coursesGoalsSet.isEmpty()) {
				for (CoursesGoal coursesGoal : coursesGoalsSet) {

					UserSubjectCoursesGoal userSubjectCoursesGoal = new UserSubjectCoursesGoal();
					userSubjectCoursesGoal.setCoursesgoal(coursesGoal);
					userSubjectCoursesGoal.setUser(sinhVien);
					userSubjectCoursesGoal.setSubject(subject);
					float percent = coursesGoalMap.get(coursesGoal);
					userSubjectCoursesGoal.setPercent(percent);
					if (percent >= 50) {
						userSubjectCoursesGoal.setEvaluate("Đạt");
					} else {
						userSubjectCoursesGoal.setEvaluate("Chưa đạt");
					}
					userSubjectCoursesGoals.add(userSubjectCoursesGoal);
				}
			}

		}

		// luu vao co so du lieu
		for (UserSubjectCoursesGoal userSubjectCoursesGoal : userSubjectCoursesGoals) {
			userSubjectCoursesGoalRepository.save(userSubjectCoursesGoal);
		}
	}

	private void saveTableScore(User sinhVien, Subject subject, int idCotDiem, float diemTong) {
		Scores scores = scoresRepository.findByUserAndMonhoc(sinhVien, subject);
		if (scores == null) {
			scores = new Scores();
		}
		if (idCotDiem == 1) {
			scores.setDiemQt(diemTong);

		}

		if (idCotDiem == 2) {
			scores.setDiemTh(diemTong);
		}

		if (idCotDiem == 3) {
			scores.setDiemGk(diemTong);
		}

		if (idCotDiem == 4) {
			// chua tinh diem trung binh mon hoc
			scores.setDiemCk(diemTong);
		}

		scores.setIdUser(sinhVien);
		scores.setMonhoc(subject);
		scoresRepository.save(scores);
	}

	private int getIdCotDiem(String cotDiem) {
		int idCotDiem = 0;
		switch (cotDiem) {
		case "diem-thuc-hanh":
			idCotDiem = 1;
			break;
		case "diem-qua-trinh":
			idCotDiem = 2;
			break;

		case "diem-giua-ki":
			idCotDiem = 3;
			break;

		case "diem-cuoi-ki":
			idCotDiem = 4;
			break;

		}
		return idCotDiem;
	}
}