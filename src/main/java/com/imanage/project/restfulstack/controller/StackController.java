package com.imanage.project.restfulstack.controller;

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
public class StackController {

	@Autowired
	private RestfulStackService restfulStackService;

	@PostMapping(value = "/push")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "500", description = "Stack Overflow") })
	public ResponseEntity<Boolean> push(@RequestParam("element") int element) {
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
	public ResponseEntity<Integer> peek() {
		int result = restfulStackService.peek();

		if (result == Integer.MIN_VALUE)
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		else {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/pop")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "500", description = "Stack Underflow") })
	public ResponseEntity<Integer> pop() {
		int result = restfulStackService.pop();

		if (result == Integer.MIN_VALUE)
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		else {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/allElement")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "500", description = "Stack Underflow") })
	public ResponseEntity<int[]> getAllElement(){
		int[] result = restfulStackService.getAllElement();
		
		if(result.length == 0) {
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
	
}
