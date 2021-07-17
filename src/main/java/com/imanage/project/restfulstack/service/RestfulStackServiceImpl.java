package com.imanage.project.restfulstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imanage.project.restfulstack.dao.Stack;

@Service
public class RestfulStackServiceImpl implements RestfulStackService<Object>{

	@Autowired
	private Stack<Object> stack;

	@Override
	public boolean push(Object element) {
		boolean result =  stack.push(element);
		
		return result;
	}

	@Override
	public Object peek() {
		Object element = stack.peek();
		return element;
	}

	@Override
	public Object pop() {
		return stack.pop();
	}

	@Override
	public List<Object> getAllElement() {
		return stack.getAllElement();
	}
}
