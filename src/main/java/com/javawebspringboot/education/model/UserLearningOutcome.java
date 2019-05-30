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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_learningoutcome")
public class UserLearningOutcome implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_user_learning_outcome")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserLearningOutcome;

    @JoinColumn(name = "id_user")
    @OneToOne
    private User user;

    @JoinColumn(name = "id_learningoutcome", referencedColumnName = "id_chuandaura")
    @ManyToOne(fetch = FetchType.LAZY)
    private LearningOutcome learningoutcome;

    @Column(name = "percent")
    private Float percent;

    @Column(name = "evaluate")
    private String evaluate;

    public UserLearningOutcome() {
        super();
    }

    public UserLearningOutcome(User user, LearningOutcome learningoutcome, Float percent, String evaluate) {
        this.user = user;
        this.learningoutcome = learningoutcome;
        this.percent = percent;
        this.evaluate = evaluate;
    }

    public LearningOutcome getLearningoutcome() {
        return learningoutcome;
    }

    public void setLearningoutcome(LearningOutcome learningoutcome) {
        this.learningoutcome = learningoutcome;
    }

    public Integer getIdUserLearningOutcome() {
        return idUserLearningOutcome;
    }

    public void setIdUserLearningOutcome(Integer idUserLearningOutcome) {
        this.idUserLearningOutcome = idUserLearningOutcome;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Float getPercent() {
        return percent;
    }

    public void setPercent(Float percent) {
        this.percent = percent;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    @Override
    public String toString() {
        return this.evaluate;
    }

}
