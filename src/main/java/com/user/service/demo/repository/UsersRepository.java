package com.user.service.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.user.service.demo.entity.UsersEntity;

/**
 * Jpa Repository.
 * 
 * @author yuvaraj
 *
 */
@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

}
