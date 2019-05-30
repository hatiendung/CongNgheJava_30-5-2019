package com.javawebspringboot.education.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import com.javawebspringboot.education.model.Subject;
import com.javawebspringboot.education.repository.SubjectRepository;
import com.javawebspringboot.education.service.SubjectService;
import com.javawebspringboot.education.utiles.TableScore;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    

    @Override
    public boolean fileHandler(MultipartFile fileExcel) throws ReadFileException {
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
                                if (cell.getCellType() == Cell.CELL_TYPE_STRING || cell.getNumericCellValue() > 10 || cell.getNumericCellValue() < 0) {

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

                return false;
            }
        } else {
            try {
                workbook = new HSSFWorkbook(fileExcel.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (TableScore tableScore : listTableScore) {
            System.out.print("Ma so sv: " + tableScore.getMaSV() + " ten sv: " + tableScore.getTenSV());
            for (Float diem : tableScore.getDsDiem()) {
                System.out.print(" cot diem: " + diem);
            }
            System.out.println("");

        }

        return true;
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

}
