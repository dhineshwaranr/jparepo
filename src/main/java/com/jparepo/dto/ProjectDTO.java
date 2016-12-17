package com.jparepo.dto;

import java.util.List;

import com.jparepo.pojo.TeamEntity;
import com.jparepo.pojo.UserEntity;

public class ProjectDTO {

	public int projectId;
	public String projectName;
	public List<UserDTO> user;
	public List<TeamDTO> team;
	
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
	public List<UserDTO> getUser() {
		return user;
	}
	public void setUser(List<UserDTO> user) {
		this.user = user;
	}
	public List<TeamDTO> getTeam() {
		return team;
	}
	public void setTeam(List<TeamDTO> team) {
		this.team = team;
	}
	
	
	
	
}
