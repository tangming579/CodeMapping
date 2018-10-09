package com.tm.system.mapper;

import java.util.List;

import com.tm.system.bean.User;
import com.tm.system.bean.UserWithRole;

public interface UserMapper {

	List<User> findUserWidthDep();
	
	List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);
}
