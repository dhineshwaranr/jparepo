package com.jparepo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.jparepo.dto.ProjectDTO;
import com.jparepo.dto.TeamDTO;
import com.jparepo.dto.UserDTO;
import com.jparepo.jsonview.Views;
import com.jparepo.pojo.ProjectEntity;
import com.jparepo.pojo.TeamEntity;
import com.jparepo.pojo.UserEntity;
import com.jparepo.repo.ProjectRepoImple;
import com.jparepo.repo.TeamRepoImple;
import com.jparepo.repo.UserRepoImple;


@Controller
public class HomeController {

	@Autowired
	private UserRepoImple userRepo;
	
	@Autowired
	private TeamRepoImple teamRepo;
	
	@Autowired
	private ProjectRepoImple projectRepo;
	
	@RequestMapping(value="/getUsers/{userId}",method=RequestMethod.GET)
	@ResponseBody
	public String getUser(@PathVariable(value="userId") String userId){
		System.out.println("user: " +userId);
		UserEntity user = userRepo.findById(Integer.parseInt(userId));
		System.out.println(user.getName());
		System.out.println(user.getTeam().getTeamName());
		for(ProjectEntity pe : user.getProjects()){
			System.out.println(pe.getProjectName());
		}
		return "Success";
	}
	
	@RequestMapping(value="/getTeam/{teamId}",method=RequestMethod.GET)
	@ResponseBody
	public String getTeam(@PathVariable(value="teamId") String teamId){
		System.out.println("user: " +teamId);
		TeamEntity team = teamRepo.findById(Integer.parseInt(teamId));
		System.out.println(team.getTeamName());
		for(UserEntity ue : team.getUsers()){
			System.out.println(ue.getName());
		}
		return "Success";
	}
	
	@RequestMapping(value="/getProject/{projectId}",method=RequestMethod.GET)
	@JsonView(Views.View.class)
	@ResponseBody
	public ProjectEntity getProject(@PathVariable(value="projectId") String projectId){
		ProjectEntity project = projectRepo.findById(Integer.parseInt(projectId));
		System.out.println(project.getProjectName());
		for(UserEntity ue : project.getUsers()){
			System.out.println(ue.getName());
		}
		for(TeamEntity te : project.getTeams()){
			System.out.println(te.getTeamName());
		}
		return project;
	}
	
	@RequestMapping(value="/getByTeamProject/{projectId}/{teamId}",method=RequestMethod.GET)
	@ResponseBody
	public String getByTeamAndProject(@PathVariable(value="projectId") ProjectEntity project, @PathVariable(value="teamId") TeamEntity team){
		List<UserEntity> p =userRepo.findByProjectsAndTeam(project, team);
		p.forEach(i -> System.out.println(i.getName()));
		return "Success";
	}
	
	@RequestMapping(value="/getByUserProject/{userId}/{projectId}",method=RequestMethod.GET)
	@ResponseBody
	public String getByUserAndProject(@PathVariable(value="userId") UserEntity user, @PathVariable(value="projectId") ProjectEntity project){
		List<TeamEntity> p = teamRepo.findByUsersAndProjects(user, project);
		p.forEach(i -> System.out.println(i.getTeamName()));
		return "Success";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	@ResponseBody
	public String addUser(@ModelAttribute UserEntity user){
		System.out.println(user.getName());
		//UserEntity user = new UserEntity();
		try{
			UserEntity userentity = userRepo.save(user);
			System.out.println(userentity);
		}catch(Exception e){
			System.out.println(e);
		}
		return "Success";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	@ResponseBody
	public List<UserDTO> readAllUser(){
		List<UserEntity> userentity = null;
		List<UserDTO> userDto = null;
		try{
			userentity = userRepo.findAll();
			userDto = generateUserList(userentity);
		}catch(Exception e){
			System.out.println(e);
		}
		return userDto;
	}
	
	@RequestMapping(value="/team",method=RequestMethod.GET)
	@ResponseBody
	public List<TeamDTO> readAllTeams(){
		List<TeamEntity> teamentity = null;
		List<TeamDTO> teamDto = null;
		try{
			teamentity = teamRepo.findAll();
			teamDto = generateTeamList(teamentity);
		}catch(Exception e){
			System.out.println(e);
		}
		return teamDto;
	}
	
	public List<UserDTO> generateUserList(List<UserEntity> userentity){
		List<UserDTO> userDto = new ArrayList<UserDTO>();
		for(UserEntity user : userentity){
			List<ProjectDTO> projectDtoList = new ArrayList<ProjectDTO>();
			UserDTO userDtoObj = new UserDTO();
			userDtoObj.setUserId(user.getId());
			userDtoObj.setUserName(user.getName());
			for(ProjectEntity project : user.getProjects()){
				ProjectDTO projectDto = new ProjectDTO();
				projectDto.setProjectId(project.getId());
				projectDto.setProjectName(project.getProjectName());
				projectDtoList.add(projectDto);
			}
			userDtoObj.setProjects(projectDtoList);
			TeamDTO teamDto = new TeamDTO();
			teamDto.setTeamId(user.getTeam().getId());
			teamDto.setTeamName(user.getTeam().getTeamName());
			userDtoObj.setTeam(teamDto);
			userDto.add(userDtoObj);
		}
		return userDto;
	}
	
	public List<TeamDTO> generateTeamList(List<TeamEntity> teamentity){
		List<TeamDTO> teamDto = new ArrayList<TeamDTO>();
		for(TeamEntity team : teamentity){
			List<ProjectDTO> projectDtoList = new ArrayList<ProjectDTO>();
			List<UserDTO> userDtoList = new ArrayList<UserDTO>();
			TeamDTO teamDtoObj = new TeamDTO();
			teamDtoObj.setTeamId(team.getId());
			teamDtoObj.setTeamName(team.getTeamName());
			for(ProjectEntity project : team.getProjects()){
				ProjectDTO projectDto = new ProjectDTO();
				projectDto.setProjectId(project.getId());
				projectDto.setProjectName(project.getProjectName());
				projectDtoList.add(projectDto);
			}
			for(UserEntity user : team.getUsers()){
				UserDTO userDto = new UserDTO();
				userDto.setUserId(user.getId());
				userDto.setUserName(user.getName());
				userDtoList.add(userDto);
			}
			teamDtoObj.setProject(projectDtoList);
			teamDtoObj.setUser(userDtoList);
			teamDto.add(teamDtoObj);
		}
		return teamDto;
	}
	
}
