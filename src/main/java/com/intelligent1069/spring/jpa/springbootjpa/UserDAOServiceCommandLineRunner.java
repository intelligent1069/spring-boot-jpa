package com.intelligent1069.spring.jpa.springbootjpa;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.intelligent1069.spring.jpa.springbootjpa.entiry.User;
import com.intelligent1069.spring.jpa.springbootjpa.service.UserDAOService;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner{

	private static final Logger log 
		= LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
	
	@Autowired
	private UserDAOService userDAOService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user = new User("Niru","Admin");
		long insert = userDAOService.insert(user);
		log.info("new user created is ==>>>" + user);
	}

}
