package com.imanage.project.restfulstack.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Stack<T> {

	@Value("${stack.size}")
	private int size;
	
	int top;
	
	ArrayList<T> data;	
	
	@PostConstruct
	public void init() {
		this.data = new ArrayList<T>(size);
		this.top = -1;
	}
	public boolean push(T element) {
		if(top >= (size - 1)) {
			return false;
		}else {
			top = top+1;
			if(data.size() > top)
				data.set(top, element);
			else {
				data.add(element);
			}
			return true;
		}
	}
	
	public T pop() {
		if(isEmpty()) {
			return null;
		}else {
			return data.get(top--);
		}
	}
	
	public T peek() {
		if(isEmpty())
			return null;
		
		return this.data.get(top);
	}
	
	public List<T> getAllElement() {
		if(isEmpty())
			return null;
		int i = top;
		List<T> reverseList = new ArrayList<T>(top+1);
		while(i >= 0) {
			reverseList.add(this.data.get(i));
			i--;
		}
		return reverseList;
	}
	
	private boolean isEmpty() {
		return top <0;
	}
}
