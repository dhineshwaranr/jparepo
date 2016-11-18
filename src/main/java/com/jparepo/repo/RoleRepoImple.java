package com.jparepo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jparepo.pojo.RoleEntity;
import com.jparepo.pojo.UserEntity;

@Repository
public interface RoleRepoImple extends JpaRepository<RoleEntity, Integer> {
	
	public RoleEntity findById(int roleId);

}
