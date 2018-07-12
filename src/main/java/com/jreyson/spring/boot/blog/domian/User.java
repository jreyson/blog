package com.jreyson.spring.boot.blog.domian;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User 瀹炰綋
 * @author Administrator
 *
 */
@Entity	//实体标识
public class User {

	@Id  //主键标识
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自增策略
	private Long id;	//瀹炰綋鍞竴鏍囪瘑
	private String name;
	private String email;
	
	protected User() {	//无参构造函数  设置为protected 防止直接使用
		
	}
	
	public User(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return String.format("User[id=%d,name=%s,email=%s]", id,name,email);
	}
	
}
