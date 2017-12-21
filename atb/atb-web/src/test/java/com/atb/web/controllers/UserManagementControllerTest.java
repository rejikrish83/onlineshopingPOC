package com.atb.web.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.atb.model.User;
import com.atb.web.service.UserManagementService;


@RunWith(MockitoJUnitRunner.class)
public class UserManagementControllerTest {

	@Mock
	private UserManagementService mockUserService;

	@InjectMocks
	private UserManagementController userManagementController = new UserManagementController();
	@Before
	public void init() {
		 MockitoAnnotations.initMocks(this);
	}

	@Test
	public void listAllSites() {
		when(mockUserService.findUserById(any())).thenReturn(null);
		ResponseEntity<?> responseEntity = userManagementController.getUserDetails(any());
		verify(mockUserService).findUserById(any());
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

		User mockUser  = new User();
		mockUser.setId(1L);
		mockUser.setUserName("reji");
		when(mockUserService.findUserById(any())).thenReturn(mockUser);
		responseEntity = userManagementController.getUserDetails(any());
		verify(mockUserService, times(2)).findUserById(any());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
