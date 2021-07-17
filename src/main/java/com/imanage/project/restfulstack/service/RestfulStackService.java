package com.imanage.project.restfulstack.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface RestfulStackService<T> {
	
	boolean push(T element);
	
	T peek();
	
	T pop();
	
	List<T> getAllElement();
}
