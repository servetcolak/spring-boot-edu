package com.training.spring.security.repo;

import org.springframework.data.repository.CrudRepository;

import com.training.spring.security.RoleObject;

public interface IRoleRepo extends CrudRepository<RoleObject, Long> {

	RoleObject findByRoleName(String rolename);
}
