package com.training.spring.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.security.RoleObject;
import com.training.spring.security.UserObject;
import com.training.spring.security.repo.IRoleRepo;
import com.training.spring.security.repo.IUserRepo;

@Validated
@RestController
@RequestMapping("/user")
public class UserRest {

	@Autowired
	private IUserRepo userRepo;

	@Autowired
	private IRoleRepo roleRepo;

	@Autowired
	private BCryptPasswordEncoder enc;
	
	@RequestMapping("/create/{username}/{password}/{roleName}")
	public String createUser(@NotNull @PathVariable("username") String username,
			@NotNull @PathVariable("password") String password, @NotNull @PathVariable("roleName") String roleName) {

		try {
			RoleObject role = roleRepo.findByRoleName(roleName);
			if (role == null) {
				role = new RoleObject();
				role.setRoleName(roleName);
				role = roleRepo.save(role);
			}

			UserObject userObject = userRepo.findByUsername(username);
			if (userObject != null) {
				return "User already in DB";
			}
			userObject = new UserObject();
			userObject.setName(username);
			userObject.setSurname(username);
			userObject.setUsername(username);
			userObject.setPassword(enc.encode(password));

			List<RoleObject> roles = new ArrayList<RoleObject>();
			roles.add(role);
			
			userObject.setRoles(roles);

			userObject = userRepo.save(userObject);

			return "OK";
		} catch (Exception e) {
			throw new ValidationException();
		}

	}
	
	@RequestMapping("/test")
	public String test() {
		return "OK";
	}
}
