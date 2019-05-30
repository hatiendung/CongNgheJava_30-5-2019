package com.javawebspringboot.education.utiles;

import java.util.List;

public class TableScore {

    private String maSV;
    private String tenSV;
    private List<Float> dsDiem;

    public TableScore() {
    }

    public TableScore(String maSV, String tenSV, List<Float> dsDiem) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.dsDiem = dsDiem;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public List<Float> getDsDiem() {
        return dsDiem;
    }

    public void setDsDiem(List<Float> dsDiem) {
        this.dsDiem = dsDiem;
    }

    @Override
    public String toString() {

        return this.maSV + " - " + this.tenSV;
    }

}
