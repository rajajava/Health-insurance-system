package com.his.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.Repository.RoleRepository;
import com.his.entity.RoleEntity;
import com.his.service.RoleService;
@Service
public class UserRoleServiceImpl implements RoleService {
  
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Map<Integer, String> getAllRoles() {
		Map<Integer,String> userRoles=new HashMap<Integer,String>();
		List<RoleEntity> roles=roleRepository.findAll();
		
		for(RoleEntity role:roles) {
			userRoles.put(role.getRoleId(),role.getRole());
		}
		return userRoles;
	}

}
