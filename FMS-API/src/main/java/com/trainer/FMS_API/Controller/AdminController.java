package com.trainer.FMS_API.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainer.FMS_API.Model.GuiLoginRequest;
import com.trainer.FMS_API.Model.GuiLoginResponse;
import com.trainer.FMS_API.Model.UpdatePasswordRequest;
import com.trainer.FMS_API.Service.GuiUserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AdminController {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	GuiUserService guiUserService;

	
	
	
	@ApiOperation(value = "GUI Login Api", response = String.class)
	@PostMapping("/adminLogin")
	public MappingJacksonValue guiLogin(@RequestBody GuiLoginRequest guiLoginRequest) {

		log.info("Gui Login request ={}", guiLoginRequest);

		GuiLoginResponse response = guiUserService.login(guiLoginRequest);
		log.info("GUI login response ={}", response);
		MappingJacksonValue mapping = new MappingJacksonValue(response);
		return mapping;

	}

	
	@ApiOperation(value = "GUI Password Change Api", response = String.class)
	@PostMapping("/changePassword")
	public String updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
		log.info("Password change request Recive id ={}", updatePasswordRequest);

		return guiUserService.updatePasswordRequest(updatePasswordRequest);

	}

	
	@ApiOperation(value = "GUI Create Admin Api", response = String.class)
	@PostMapping("/createUser")
	public String createUser(@RequestBody GuiLoginRequest guiLoginRequest) {

		log.info("create user request ={}", guiLoginRequest);

		return guiUserService.createUser(guiLoginRequest);

	}

	@ApiOperation(value = "GUI Forgotton Password Api", response = String.class)
	@GetMapping("/forgottenPassword")
	public String forgottenPassword(@RequestParam("userName") String userName) {

		log.info("Forgotten Password Change request userName ={}", userName);

		return guiUserService.forgottenPassword(userName);

	}

}
