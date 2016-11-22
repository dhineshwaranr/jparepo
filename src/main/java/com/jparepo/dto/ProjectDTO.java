package com.jparepo.dto;

import java.util.List;

import com.jparepo.pojo.TeamEntity;
import com.jparepo.pojo.UserEntity;

public class ProjectDTO {

	public int projectId;
	public String projectName;
	public List<UserEntity> user;
	public List<TeamEntity> team;
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<UserEntity> getUser() {
		return user;
	}
	public void setUser(List<UserEntity> user) {
		this.user = user;
	}
	public List<TeamEntity> getTeam() {
		return team;
	}
	public void setTeam(List<TeamEntity> team) {
		this.team = team;
	}
	
	
	
	
}
