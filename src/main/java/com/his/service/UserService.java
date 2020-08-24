package com.his.service;

import java.util.List;

import com.his.dto.UnlockAcc;
import com.his.dto.User;




public interface UserService {
	
	public boolean saveUserDtls(User user);
	public String validEmail(String userEmail);
	public User updateTempPwdToNewPwd(UnlockAcc unlockAcc);
	public boolean updateUserAcc(User user);
	public String validPazzword( String userEmail, String userPazzword);
	 public List<User> getUsersByRoleId(Integer roleId);
	 public User getUserByID(Integer userId);
	 public boolean userDelete(User user);
}
