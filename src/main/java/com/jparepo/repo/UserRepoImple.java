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
public interface UserRepoImple extends JpaRepository<UserEntity, Integer>{

	public UserEntity save(UserEntity user);
	public UserEntity findById(int userId);
	public List<UserEntity> findAll();
	public List<UserEntity> findByTeam(TeamEntity team);
	public List<UserEntity> findByProjectsAndTeam(ProjectEntity project, TeamEntity team);
	
}