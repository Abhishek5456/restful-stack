package com.imanage.project.restfulstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imanage.project.restfulstack.dao.Stack;

@Service
public class RestfulStackServiceImpl implements RestfulStackService{

	@Autowired
	private Stack stack;

	@Override
	public boolean push(int element) {
		boolean result =  stack.push(element);
		
		return result;
	}

	@Override
	public int peek() {
		int element = stack.peek();
		
		return element;
	}

	@Override
	public int pop() {
		int element = stack.pop();
		
		return element;
	}
}
