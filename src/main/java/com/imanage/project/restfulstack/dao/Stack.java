package com.imanage.project.restfulstack.dao;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Stack {

	@Value("${stack.size}")
	private int size;
	
	int top;
	
	int[] data;	
	
	@PostConstruct
	public void init() {
		System.out.println("I have been called");
		data = new int[size];
		top = -1;
	}
	public boolean push(int element) {
		if(top >= (size - 1))
			return false;

		data[++top] = element;
		return true;
	}
	
	public int pop() {
		if(isEmpty())
			return Integer.MIN_VALUE;

		int element = data[top--];		
		return element;
	}
	
	public int peek() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		
		return data[top];
	}
	
	private boolean isEmpty() {
		return top <0;
	}
}
