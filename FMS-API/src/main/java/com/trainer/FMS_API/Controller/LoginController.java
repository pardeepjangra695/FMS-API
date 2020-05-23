package com.trainer.FMS_API.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trainer.FMS_API.Model.UserLoginRequest;
import com.trainer.FMS_API.Model.UserLoginResponse;
import com.trainer.FMS_API.Service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class LoginController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	UserService userService;

	@ApiOperation(value = "Login Api", response = String.class)
	@PostMapping("/login")
	public MappingJacksonValue loginUser(@RequestBody UserLoginRequest userLoginRequest) {
		log.info("Login in Api request recive={}", userLoginRequest);

		UserLoginResponse response = userService.getUserDetails(userLoginRequest);

		log.info("Login Api Response ={}", response);

		MappingJacksonValue mapping = new MappingJacksonValue(response);
		return mapping;
	}

}
