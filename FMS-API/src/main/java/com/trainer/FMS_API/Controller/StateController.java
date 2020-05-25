package com.trainer.FMS_API.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	@ApiOperation(value = "State Update Api", response = String.class)
	@PostMapping("/updateState")
	public String updateState(@RequestBody StateModel state) {

		log.info("State update request recived ={}", state);
		return stateService.updateState(state);

	}

	@ApiOperation(value = "State Delete Api", response = String.class)
	@GetMapping("/deleteState")
	public String updateState(@RequestParam("id") int id) {

		log.info("State update request recived ={}", id);
		return stateService.deleteState(id);
	}

	@ApiOperation(value = "State Select Api", response = StateModel.class)
	@PostMapping("/getAllState")
	public MappingJacksonValue getAllState() {
		log.info("State get request recived");

		List<StateModel> response = stateService.getAllState();
		MappingJacksonValue mapping = new MappingJacksonValue(response);
		log.info("Response send back ={}", response);
		return mapping;
	}

}
