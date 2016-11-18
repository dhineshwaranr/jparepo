package com.jparepo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public String getProject(@PathVariable(value="projectId") String projectId){
		ProjectEntity project = projectRepo.findById(Integer.parseInt(projectId));
		System.out.println(project.getProjectName());
		for(UserEntity ue : project.getUsers()){
			System.out.println(ue.getName());
		}
		for(TeamEntity te : project.getTeams()){
			System.out.println(te.getTeamName());
		}
		return "Success";
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
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	@ResponseBody
	public String addUser(@ModelAttribute UserEntity user){
		System.out.println(user.getName());
		//UserEntity user = new UserEntity();
		try{
			userRepo.save(user);
		}catch(Exception e){
			System.out.println(e);
		}
		
		return "Success";
	}

}
