package com.user.service.demo.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.service.demo.entity.UsersEntity;
import com.user.service.demo.exceptionhandler.RecordNotFoundException;
import com.user.service.demo.repository.UsersRepository;
import com.user.service.demo.service.UsersService;

/**
 * User's related business logic will be here.
 * 
 * @author yuvaraj
 *
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;

	/**
	 * Fetching all users details.
	 * 
	 * @return users detailed list.
	 */
	@Override
	public List<UsersEntity> listUsers() {
		final List<UsersEntity> listUsers = usersRepository.findAll();
		if (listUsers.isEmpty()) {
			throw new RecordNotFoundException("User", "user", "list");
		}
		return listUsers;
	}

	/**
	 * Add new user.
	 * 
	 * @param user new user details.
	 * @return status code.
	 */
	@Override
	@Transactional
	public void addUser(UsersEntity userDetail) {
		usersRepository.saveAndFlush(userDetail);
	}

	/**
	 * Update users detail by user id.
	 * 
	 * @param user user details.
	 * @return status code.
	 */
	@Override
	@Transactional
	public void updateUser(UsersEntity userDetail) {
		UsersEntity user = getUser(userDetail.getId());
		user.setFirstName(userDetail.getFirstName());
		user.setLastName(userDetail.getLastName());
		user.setStatus(userDetail.getStatus());
		usersRepository.save(user);
	}

	/**
	 * Delete users detail by user id.
	 * 
	 * @param userId
	 * @return status code.
	 */
	@Override
	@Transactional
	public void removeUser(final Long userId) {
		UsersEntity user = getUser(userId);
		usersRepository.delete(user);
	}

	/**
	 * fetching users detail by user id.
	 * 
	 * @param userId user id.
	 * @return user detail.
	 */
	@Override
	public UsersEntity getUser(final Long userId) {
		return usersRepository.findById(userId).orElseThrow(() -> new RecordNotFoundException("User", "user", userId));
	}

}
