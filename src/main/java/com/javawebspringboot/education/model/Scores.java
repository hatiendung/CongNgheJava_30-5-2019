package com.javawebspringboot.education.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "scores")
public class Scores implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bangdiem")
    private Integer idBangdiem;

    @Column(name = "diem_qt")
    private Float diemQt;

    @Column(name = "diem_th")
    private Float diemTh;

    @Column(name = "diem_gk")
    private Float diemGk;

    @Column(name = "diem_ck")
    private Float diemCk;

    @Column(name = "diem_tb")
    private Float diemTb;

    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "id_monhoc", referencedColumnName = "id_monhoc")
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject monhoc;

    public Scores() {
    }

    public Scores(Float diemQt, Float diemTh, Float diemGk, Float diemCk, Float diemTb, User user, Subject monhoc) {
        super();
        this.diemQt = diemQt;
        this.diemTh = diemTh;
        this.diemGk = diemGk;
        this.diemCk = diemCk;
        this.diemTb = diemTb;
        this.user = user;
        this.monhoc = monhoc;
    }

    public Scores(Integer idBangdiem) {
        this.idBangdiem = idBangdiem;
    }

    public Integer getIdBangdiem() {
        return idBangdiem;
    }

    public void setIdBangdiem(Integer idBangdiem) {
        this.idBangdiem = idBangdiem;
    }

    public Float getDiemQt() {
        return diemQt;
    }

    public void setDiemQt(Float diemQt) {
        this.diemQt = diemQt;
    }

    public Float getDiemTh() {
        return diemTh;
    }

    public void setDiemTh(Float diemTh) {
        this.diemTh = diemTh;
    }

    public Float getDiemGk() {
        return diemGk;
    }

    public void setDiemGk(Float diemGk) {
        this.diemGk = diemGk;
    }

    public Float getDiemCk() {
        return diemCk;
    }

    public void setDiemCk(Float diemCk) {
        this.diemCk = diemCk;
    }

    public Float getDiemTb() {
        return diemTb;
    }

    public void setDiemTb(Float diemTb) {
        this.diemTb = diemTb;
    }

    public User getUser() {
        return user;
    }

    public void setIdUser(User user) {
        this.user = user;
    }

    public Subject getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(Subject monhoc) {
        this.monhoc = monhoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBangdiem != null ? idBangdiem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scores)) {
            return false;
        }
        Scores other = (Scores) object;
        if ((this.idBangdiem == null && other.idBangdiem != null) || (this.idBangdiem != null && !this.idBangdiem.equals(other.idBangdiem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Scores[ idBangdiem=" + idBangdiem + " ]";
    }

}
