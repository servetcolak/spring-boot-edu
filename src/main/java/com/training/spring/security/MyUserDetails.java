package com.training.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.training.spring.security.repo.IUserRepo;

public class MyUserDetails implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(MyUserDetails.class);

	@Autowired
	private IUserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserObject user = userRepo.findByUsername(username);
			if (user != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("User found in db, username: " + username + " Roles: " + user.getRoles());
				}

				List<RoleObject> roles = user.getRoles();
				List<GrantedAuthority> authories = new ArrayList<>();
				for (RoleObject role : roles) {
					authories.add(new SimpleGrantedAuthority(role.getRoleName()));
				}

				return new User(username, user.getPassword(), authories);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		throw new UsernameNotFoundException("Username: " + username + " is not valid!");
	}

}
