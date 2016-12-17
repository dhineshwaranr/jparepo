package com.jparepo.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.jparepo.jsonview.Views;

@Entity
@Table(name="user")
public class UserEntity implements Serializable{

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.ALL)
	private TeamEntity team;
	
	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<ProjectEntity> projects;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TeamEntity getTeam() {
		return team;
	}

	public void setTeam(TeamEntity team) {
		this.team = team;
	}

	public List<ProjectEntity> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectEntity> projects) {
		this.projects = projects;
	}
	
	
}
