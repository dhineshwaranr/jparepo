package com.jparepo.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.jparepo.jsonview.Views;

@Entity
@Table(name="team")
public class TeamEntity implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	
	private String teamName;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "team")
	private List<UserEntity> users;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProjectEntity> projects;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public List<ProjectEntity> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectEntity> projects) {
		this.projects = projects;
	}
	
	
}
