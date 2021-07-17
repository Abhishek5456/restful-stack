package com.imanage.project.restfulstack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import com.imanage.project.restfulstack.controller.StackController;


@RunWith(SpringRunner.class)
@SpringBootTest
class RestfulStackApplicationTests {

//	@Autowired
//	private MockMvc mockMvc;
	
	@MockBean
	private StackController stackController;
		
	@Test
	@DisplayName("RestApi Positive Case")
	public void positiveScenarios() {
		int element = 10;
		
		given(stackController.push(element)).willReturn(new ResponseEntity<Boolean>(true, HttpStatus.OK));
		given(stackController.peek()).willReturn(new ResponseEntity<Integer>(element, HttpStatus.OK));
		given(stackController.pop()).willReturn(new ResponseEntity<Integer>(element, HttpStatus.OK));
	}
	
	@Test
	@DisplayName("RestApi Negative Case")
	public void negativeScenarios() {
		int element = 10;

		given(stackController.push(element)).willReturn(new ResponseEntity<Boolean>(true, HttpStatus.OK));
		given(stackController.pop()).willReturn(new ResponseEntity<Integer>(element, HttpStatus.OK));
		given(stackController.pop()).willReturn(new ResponseEntity<Integer>(Integer.MIN_VALUE, HttpStatus.INTERNAL_SERVER_ERROR));
		given(stackController.peek()).willReturn(new ResponseEntity<Integer>(Integer.MIN_VALUE, HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@Test
	@DisplayName("RestApi Empty Stack Case")
	public void emptyStackTest() {
		given(stackController.pop()).willReturn(new ResponseEntity<Integer>(Integer.MIN_VALUE, HttpStatus.INTERNAL_SERVER_ERROR));
		given(stackController.peek()).willReturn(new ResponseEntity<Integer>(Integer.MIN_VALUE, HttpStatus.INTERNAL_SERVER_ERROR));
	}

}
