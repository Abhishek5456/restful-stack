package com.imanage.project.restfulstack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imanage.project.restfulstack.service.RestfulStackService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class StackController<T> {

	@Autowired
	private RestfulStackService<Object> restfulStackService;

	@PostMapping(value = "/push")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "500", description = "Stack Overflow") })
	public ResponseEntity<Boolean> push(@RequestParam("element") T element) {
		boolean result = restfulStackService.push(element);

		if (result)
			return new ResponseEntity<>(result, HttpStatus.OK);
		else {
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/peek")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "500", description = "Stack Underflow") })
	public ResponseEntity<Object> peek() {
		Object result = restfulStackService.peek();

		if (result == null)
			return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
		else {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/pop")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "500", description = "Stack Underflow") })
	public ResponseEntity<Object> pop() {
		Object result = restfulStackService.pop();

		if (result == null)
			return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
		else {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/allElement")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "500", description = "Stack Underflow") })
	public ResponseEntity<List<Object>> getAllElement(){
		List<Object> result = restfulStackService.getAllElement();
		
		if(result == null) {
			return new ResponseEntity<>(new ArrayList<Object>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
}
