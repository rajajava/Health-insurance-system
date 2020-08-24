package com.his.Repository;



import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.his.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Serializable> {

	  @Query("select userEmail from UserEntity where userEmail=?1")
	  public String  findByEmailAddress(String  userEmail);
	  
	  @Query(value = "SELECT t from  UserEntity t WHERE t.userEmail = :userEmail AND t.userPazzword = :userPazzword")
	  public UserEntity findByEmailAndTempPswd(String userEmail,String userPazzword);
	  
	  @Query(value = "SELECT t from  UserEntity t WHERE t.roleId = :roleId")
	  public List<UserEntity> findusersByRoleId(Integer roleId);
}
