package com.jparepo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jparepo.pojo.TeamEntity;
import com.jparepo.repo.TeamRepoImple;

@Controller
public class TeamsController {

	@Autowired
	private TeamRepoImple teamRepo;
	
	@RequestMapping(value="/team",method=RequestMethod.POST)
	@ResponseBody
	public String create(@ModelAttribute TeamEntity team){
		try{
			teamRepo.save(team);
		}catch(Exception e){
			System.out.println(e);
		}
		return "Success";
	}
	
	@RequestMapping(value="/team",method=RequestMethod.GET)
	@ResponseBody
	public String read(){
		try{
			List<TeamEntity> team = teamRepo.findAll();
			System.out.println(team.size());
		}catch(Exception e){
			System.out.println(e);
		}
		return "Success";
	}
	
	@RequestMapping(value="/team/{teamId}",method=RequestMethod.PUT)
	@ResponseBody
	public String update(@RequestParam("teamName") String teamName, @PathVariable(value="teamId") String teamId){
		try{
			TeamEntity team = teamRepo.findById(Integer.parseInt(teamId));
			team.setTeamName(teamName);
			TeamEntity t = teamRepo.save(team);
		}catch(Exception e){
			System.out.println(e);
		}
		return "Success";
	}
	
	@RequestMapping(value="/team/{teamId}",method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable(value="teamId") String teamId){
		try{
			TeamEntity team = teamRepo.findById(Integer.parseInt(teamId));
			teamRepo.delete(team);
		}catch(Exception e){
			System.out.println(e);
		}
		return "Success";
	}
	
}
