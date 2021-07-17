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
	
	public int[] getAllElement() {
		if(isEmpty())
			return new int[0];

		int j =0;
		int[] currentElements = new int[top+1];
		for(int i = top; i>=0; i--) {
			currentElements[j++] = data[i];
		}
		
		return currentElements;
	}
	
	private boolean isEmpty() {
		return top <0;
	}
}
