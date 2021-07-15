package com.imanage.project.restfulstack.service;

import org.springframework.stereotype.Service;

@Service
public interface RestfulStackService {
	
	boolean push(int element);
	
	int peek();
	
	int pop();
}
