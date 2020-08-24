package com.his.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.his.Repository.UserRepository;
import com.his.constance.AppConstants;
import com.his.dto.UnlockAcc;
import com.his.dto.User;
import com.his.entity.UserEntity;
import com.his.service.UserService;
import com.his.utilmail.EmailUtill;
import com.his.utiltemppwd.TempPazzword;





@Service
public class UserServiceImpl implements UserService {
 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailUtill emailUtill;
	
	@Override
	public boolean saveUserDtls(User user) {
		user.setAccstatus(AppConstants.LOCKED_STR);
		user.setUserPazzword( TempPazzword.generateTempPazzword(AppConstants.TEMP_PAZZWORD_LENGTH));
		UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(user,userEntity);
		UserEntity useracc=userRepository.save(userEntity);
		if(useracc.getUserId()!=null) {
			emailUtill.sendUserAccUnlockEmail(user);
		}
		return false;
	}


	@Override
	public String validEmail(String userEmail) {
		 if(null!=userRepository.findByEmailAddress(userEmail)) {
		return "Duplicate";
		 }
		return "unique";
		 
	}


	@Override
	public User updateTempPwdToNewPwd(UnlockAcc unlockAcc) {
		UserEntity userEntity=	userRepository.findByEmailAndTempPswd(unlockAcc.getEmail(), unlockAcc.getTempPazzword());
		User user=null;
		if(userEntity!=null)
		{
			user=new User();
			 BeanUtils.copyProperties(userEntity, user);
		}
		return user;
	}


	@Override
	public boolean updateUserAcc(User user) {
		UserEntity useraccountEntity=new UserEntity();
		BeanUtils.copyProperties(user, useraccountEntity);
		UserEntity savedEntity=userRepository.save(useraccountEntity);
		return savedEntity!=null;
		
	}


	@Override
	public String validPazzword(String userEmail, String userPazzword) {
		UserEntity useraccountEntity =userRepository.findByEmailAndTempPswd(userEmail, userPazzword);
		if(useraccountEntity != null) {
		return "password is there";
			
		}
		return "password is not there";
		
	}


	@Override
	public List<User> getUsersByRoleId(Integer roleId) {
		List<UserEntity> userEntitys=userRepository.findusersByRoleId(roleId);
		 List<User> users=new ArrayList<User>();
		 for(UserEntity userEntity:userEntitys) {
			 User user =new User();
			 BeanUtils.copyProperties(userEntity, user);
			 users.add(user);
		 }
		 
		return users;
		
	}


	@Override
	public User getUserByID(Integer userId) {
		Optional<UserEntity> findById=userRepository.findById(userId);
		if(findById.isPresent()) {
			UserEntity userEntity=findById.get();
			User user=new  User();
			BeanUtils.copyProperties(userEntity,user);
			return user;
		}
	
		return null;
	}


	@Override
	public boolean userDelete(User user) {
		user.setEnable(false);
		return this.saveUserDtls(user);
	}

}
