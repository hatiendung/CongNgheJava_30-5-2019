package com.javawebspringboot.education.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "khoa")
public class Khoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_khoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idKhoa;

	@Column(name = "tenkhoa")
	private String tenKhoa;

	@OneToMany(mappedBy = "khoa")
	private List<User> users;

	public Khoa() {
		super();
	}

	public Khoa(String tenKhoa, List<User> users) {
		super();
		this.tenKhoa = tenKhoa;
		this.users = users;
	}

	public Integer getIdKhoa() {
		return idKhoa;
	}

	public void setIdKhoa(Integer idKhoa) {
		this.idKhoa = idKhoa;
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
