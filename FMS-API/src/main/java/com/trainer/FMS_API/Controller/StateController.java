package com.trainer.FMS_API.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trainer.FMS_API.Model.StateModel;
import com.trainer.FMS_API.Service.StateService;

import io.swagger.annotations.ApiOperation;

@RestController
public class StateController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	StateService stateService;

	@ApiOperation(value = "State ADD Api", response = String.class)
	@PostMapping("/addState")
	public String addState(@RequestBody StateModel state) {

		log.info("State add request recived ={}", state);
		return stateService.addState(state);

	}

}
