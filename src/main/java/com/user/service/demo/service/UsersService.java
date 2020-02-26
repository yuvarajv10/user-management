package com.user.service.demo.service;

import java.util.List;

import com.user.service.demo.entity.UsersEntity;

/**
 * Users related services.
 * 
 * @author yuvaraj
 *
 */
public interface UsersService {

	/**
	 * Fetching all users details.
	 * 
	 * @return users detailed list.
	 */
	List<UsersEntity> listUsers();

	/**
	 * Add new user.
	 * 
	 * @param user new user details.
	 * @return status code.
	 */
	void addUser(UsersEntity userDetail);

	/**
	 * Update users detail by user id.
	 * 
	 * @param user user details.
	 * @return status code.
	 */
	void updateUser(UsersEntity userDetail);

	/**
	 * Delete users detail by user id.
	 * 
	 * @param userId
	 * @return status code.
	 */
	void removeUser(Long userId);

	/**
	 * fetching users detail by user id.
	 * 
	 * @param userId user id.
	 * @return user detail.
	 */
	UsersEntity getUser(Long userId);

}
