package com.training.spring.security.repo;

import org.springframework.data.repository.CrudRepository;

import com.training.spring.security.UserObject;

public interface IUserRepo extends CrudRepository<UserObject, Long> {

	UserObject findByUsername(String username);
}
