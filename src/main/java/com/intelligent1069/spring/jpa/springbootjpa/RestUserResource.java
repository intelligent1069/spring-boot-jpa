package com.intelligent1069.spring.jpa.springbootjpa;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.intelligent1069.spring.jpa.springbootjpa.entiry.User;
import com.intelligent1069.spring.jpa.springbootjpa.service.UserRepository;

@RestController
public class RestUserResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	 
	public Resource<User> getUserById(@PathVariable long id) {
		Optional<User> user = userRepository.findById(id);
		
		Resource<User> resource = new Resource<User>(user.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());

		resource.add(linkTo.withRel("all-users"));

		// HATEOAS

		return resource;
	}

	@DeleteMapping("/users/{id}")
	 
	public void delUserById(@PathVariable long id) {
		 userRepository.deleteById(id);
	}
	
	@PostMapping("/users")
	 
	public ResponseEntity<Object> insertUser(@RequestBody User user) {
		 User saveduser = userRepository.save(user);
			
		 URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(saveduser.getId()).toUri();
				
				return ResponseEntity.created(location).build();
				
	}
}
