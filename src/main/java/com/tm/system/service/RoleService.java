package com.tm.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tm.codemapping.utils.StringUtils;
import com.tm.system.bean.Role;
import com.tm.system.mapper.RoleMapper;
import com.tm.system.mapper.RoleResourcesMapper;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleResourcesMapper roleResourcesMapper;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RoleResourcesService roleResourcesService;
	
	public List<Role> findUserRole(String userName){
		return this.roleMapper.findUserRole(userName);
	}
	
	
}
