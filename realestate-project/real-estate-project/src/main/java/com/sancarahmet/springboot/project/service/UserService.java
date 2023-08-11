package com.sancarahmet.springboot.project.service;

import com.sancarahmet.springboot.project.entity.User;
import com.sancarahmet.springboot.project.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	void save(WebUser webUser);

}
