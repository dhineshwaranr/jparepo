package com.jparepo.dto;

import java.util.List;

import com.jparepo.pojo.TeamEntity;

public class UserDTO {

	public int userId;
	public String userName;
	public List<ProjectDTO> projects;
	public TeamDTO team;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<ProjectDTO> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}
	public TeamDTO getTeam() {
		return team;
	}
	public void setTeam(TeamDTO team) {
		this.team = team;
	}
	
	
}
