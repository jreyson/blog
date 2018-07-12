package com.jreyson.spring.boot.blog.repository;


import org.springframework.data.repository.CrudRepository;

import com.jreyson.spring.boot.blog.domian.User;

/**
 * User Repository 接口
 * 
 * @author Administrator
 *
 */
public interface UserRepository extends CrudRepository<User, Long>{

	
}
