package com.javawebspringboot.education.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public LearningOutcome() {
        super();
    }

    public LearningOutcome(String kiHieu, String tenChuanDauRa, List<UserLearningOutcome> userLearningoutcomeList) {
        this.kiHieu = kiHieu;
        this.tenChuanDauRa = tenChuanDauRa;
        this.userLearningoutcomeList = userLearningoutcomeList;
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
