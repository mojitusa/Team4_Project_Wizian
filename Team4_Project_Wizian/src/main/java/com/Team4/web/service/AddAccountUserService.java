package com.Team4.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Team4.web.entity.User;
import com.Team4.web.model.AddAccountUserModel;
import com.Team4.web.repository.AddAccountUserRepo;

@Service
public class AddAccountUserService {

	@Autowired
	private AddAccountUserRepo addAccountUser;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional(timeout = 10)
	public void addAccount(AddAccountUserModel userModel) {
		
		User data = new User();
		
		//db에 이미 동일한 username을 가진 회원이 존재하는지?
		
		data.setPw(bCryptPasswordEncoder.encode(userModel.getPW()));
		data.setSe_cd("11");
		
		addAccountUser.save(data);
		
	}
}
