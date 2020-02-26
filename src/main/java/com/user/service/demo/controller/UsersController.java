package com.user.service.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.user.service.demo.entity.UsersEntity;
import com.user.service.demo.service.UsersService;

/**
 * Users Controller.
 * 
 * @author yuvaraj
 *
 */
@RestController
@RequestMapping("/usersApi")
@RestControllerAdvice
public class UsersController {

	@Autowired
	UsersService usersService;

	/**
	 * Fetching all users details.
	 * 
	 * @return users detailed list.
	 */
	@GetMapping(value = "/allUsers")
	public List<UsersEntity> getAllUsers() {
		return usersService.listUsers();
	}

	/**
	 * Add new user.
	 * 
	 * @param user new user details.
	 * @return status code.
	 */
	@PostMapping(value = "/saveUser")
	public ResponseEntity<?> saveUser(@Valid @RequestBody UsersEntity user) {
		usersService.addUser(user);
		return ResponseEntity.ok().build();
	}

	/**
	 * Update users detail by user id.
	 * 
	 * @param user user details.
	 * @return status code.
	 */
	@PutMapping(value = "/updateUser")
	public ResponseEntity<?> updateUser(@Valid @RequestBody UsersEntity user) {
		usersService.updateUser(user);
		return ResponseEntity.ok().build();
	}

	/**
	 * Delete users detail by user id.
	 * 
	 * @param userId
	 * @return status code.
	 */
	@DeleteMapping(value = "/removeUser/{userId}")
	public ResponseEntity<?> removeUser(@PathVariable(value = "userId") Long userId) {
		usersService.removeUser(userId);
		return ResponseEntity.ok().build();
	}

	/**
	 * fetching users detail by user id.
	 * 
	 * @param userId user id.
	 * @return user detail.
	 */
	@GetMapping(value = "/getUser/{userId}")
	public ResponseEntity<UsersEntity> getUser(@PathVariable(value = "userId") Long userId) {
		return new ResponseEntity<>(usersService.getUser(userId), HttpStatus.OK);
	}

}
