package com.intelligent1069.spring.jpa.springbootjpa;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.intelligent1069.spring.jpa.springbootjpa.entiry.User;
import com.intelligent1069.spring.jpa.springbootjpa.service.UserDAOService;
import com.intelligent1069.spring.jpa.springbootjpa.service.UserRepository;

@Component
public class UserRepositoryServiceCommandLineRunner implements CommandLineRunner{

	private static final Logger log 
		= LoggerFactory.getLogger(UserRepositoryServiceCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user = new User("Popu","Admin");
		
		userRepository.save(user);
		log.info("new user created is ==>>>" + user);
		
		Optional<User> idone = userRepository.findById(1L);
		log.info("user retrieved is ==>>>" + idone);
		
		List<User> allUser = userRepository.findAll();
		log.info("all user ==>>>" + allUser);
		
		userRepository.deleteById(1L);
				
		List<User> allUsers = userRepository.findAll();
		log.info("all user ==>>>" + allUsers);
		
	}

}
