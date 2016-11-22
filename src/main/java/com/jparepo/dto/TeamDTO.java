package com.jparepo.dto;

import java.util.List;

import com.jparepo.pojo.ProjectEntity;
import com.jparepo.pojo.UserEntity;

public class TeamDTO {

	public int teamId;
	public String teamName;
	public List<ProjectDTO> project;
	public List<UserDTO> user;
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<ProjectDTO> getProject() {
		return project;
	}
	public void setProject(List<ProjectDTO> project) {
		this.project = project;
	}
	public List<UserDTO> getUser() {
		return user;
	}
	public void setUser(List<UserDTO> user) {
		this.user = user;
	}
	
	
	
}
