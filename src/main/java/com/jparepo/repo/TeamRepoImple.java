package com.jparepo.repo;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jparepo.pojo.ProjectEntity;
import com.jparepo.pojo.TeamEntity;
import com.jparepo.pojo.UserEntity;

@Repository
public interface TeamRepoImple extends JpaRepository<TeamEntity, Integer> {

	public List<TeamEntity> findById(int teamId);
	public TeamEntity findByProjects(ProjectEntity project);
	public List<TeamEntity> findByUsersAndProjects(UserEntity user, ProjectEntity project);
	
}
