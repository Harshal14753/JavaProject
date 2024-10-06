package com.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.notes.entity.User;
import com.notes.repository.UserRepo;

import jakarta.servlet.http.HttpSession;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public User saveUser(User user) {
		user.setRole("ROLE_USER");
		String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		
		User newUser = userRepo.save(user);
		
		return newUser;
	}

	@Override
	public void removeSessionMessage() {
		HttpSession session =(((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession());
		
		session.removeAttribute("msg1");
		session.removeAttribute("msg2");
		
	}

}
