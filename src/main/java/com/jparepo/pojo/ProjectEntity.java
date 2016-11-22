package com.jparepo.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.jparepo.jsonview.Views;


@Entity
@Table(name="project")
public class ProjectEntity implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	private String projectName;
		
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "projects")
	private List<TeamEntity> teams;
	
	@JsonBackReference
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "projects")
	private List<UserEntity> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<TeamEntity> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamEntity> teams) {
		this.teams = teams;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
	
}
