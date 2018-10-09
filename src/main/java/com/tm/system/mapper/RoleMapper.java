package com.tm.system.mapper;

import java.util.List;

import com.tm.system.bean.Role;
import com.tm.system.bean.RoleWithResources;


public interface RoleMapper {

	List<Role> findUserRole(String userName);
	
	List<RoleWithResources> findById(Long roleId);
}
