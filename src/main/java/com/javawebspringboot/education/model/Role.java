package com.javawebspringboot.education.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_role")
	private Integer idRole;
	@Column(length = 45)
	private String name;
	@ManyToMany(mappedBy = "roleList")
	private List<User> userList;

	public Role() {
	}

	public Role(Integer idRole) {
		this.idRole = idRole;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idRole != null ? idRole.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Role)) {
			return false;
		}
		Role other = (Role) object;
		if ((this.idRole == null && other.idRole != null)
				|| (this.idRole != null && !this.idRole.equals(other.idRole))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Role[ idRole=" + idRole + " ]";
	}

}
