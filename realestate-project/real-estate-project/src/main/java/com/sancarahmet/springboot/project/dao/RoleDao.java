package com.sancarahmet.springboot.project.dao;

import com.sancarahmet.springboot.project.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
