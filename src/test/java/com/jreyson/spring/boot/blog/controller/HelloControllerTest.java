package com.jreyson.spring.boot.blog.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	/*
		1��mockMvc.performִ��һ������
		2��MockMvcRequestBuilders.get("/user/1")����һ������
		3��ResultActions.andExpect���ִ����ɺ�Ķ���
		4��ResultActions.andDo���һ���������������ʾҪ�Խ������ʲô���飬
		       ����˴�ʹ��MockMvcResultHandlers.print()���������Ӧ�����Ϣ��
		5��ResultActions.andReturn��ʾִ����ɺ󷵻���Ӧ�Ľ����
	*/
	
	@Test
	public void testHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("helloworld")));
	}

}
