package com.javawebspringboot.education.model;

import java.io.Serializable;

import javax.persistence.Basic;
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
@Table(name = "testsubject")
public class TestSubject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_testsubject")
	private Integer idTestSubject;

	@Column(name = "name_testsubject")
	private String tenKithi;

	@JoinColumn(name = "id_subject", referencedColumnName = "id_monhoc")
	@ManyToOne(fetch = FetchType.LAZY)
	private Subject subject;

	public TestSubject() {
		super();
	}

	public TestSubject(String tenKithi, Subject subject) {
		super();
		this.tenKithi = tenKithi;
		this.subject = subject;
	}

	public Integer getIdTestSubject() {
		return idTestSubject;
	}

	public void setIdTestSubject(Integer idTestSubject) {
		this.idTestSubject = idTestSubject;
	}

	public String getTenKithi() {
		return tenKithi;
	}

	public void setTenKithi(String tenKithi) {
		this.tenKithi = tenKithi;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
