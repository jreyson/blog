package com.jreyson.spring.boot.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jreyson.spring.boot.blog.domian.User;
import com.jreyson.spring.boot.blog.repository.UserRepository;

/**
 * Hello 控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 查询所有用户
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("title","用户管理");
		return new ModelAndView("users/list","userModel",model);
	}
	
	/**
	 * 根据id查询用户
	 * @param model
	 * @return
	 */
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id ,Model model) {
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		model.addAttribute("title","查看用户");
		return new ModelAndView("users/view","userModel",model);
	}
	
	/**
	 * 获取创建表单页面
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User(null,null,null));
		model.addAttribute("title","创建用户");
		return new ModelAndView("users/form","userModel",model);
	}
	
	/**
	 * 新建或者更新用户
	 * @param model
	 * @return
	 */
	@PostMapping
	public ModelAndView saveOrUpdateUser(User user) {
		user = userRepository.save(user);
		return new ModelAndView("redirect:/users");//重定向到list页面
	}
	
	/**
	 * 根据id删除用户
	 * @param model
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		userRepository.delete(id);
		return new ModelAndView("redirect:/users");//重定向到list页面
	}
	
	/**
	 * 获取修改用户的界面
	 * @param model
	 * @return
	 */
	@GetMapping("/modify/{id}")
	public ModelAndView modify(@PathVariable("id") Long id ,Model model) {
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		model.addAttribute("title", "修改用户");
		return new ModelAndView("users/form", "userModel", model);
	}
	
	
}
