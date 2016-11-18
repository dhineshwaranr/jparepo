package com.jparepo.repo;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jparepo.pojo.ProjectEntity;
import com.jparepo.pojo.TeamEntity;

public interface ProjectRepoImple extends JpaRepository<ProjectEntity, Integer> {

	public ProjectEntity findById(int projectId);
	
	//public ProjectEntity findByProjectAndTeam(int project, TeamEntity teamId);
	
}
