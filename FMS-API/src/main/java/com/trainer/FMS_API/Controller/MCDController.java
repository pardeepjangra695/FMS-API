package com.trainer.FMS_API.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainer.FMS_API.Model.MCDModel;
import com.trainer.FMS_API.Service.MCDService;

import io.swagger.annotations.ApiOperation;

@RestController
public class MCDController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	MCDService mCDService;

	@ApiOperation(value = "MCD ADD Api", response = String.class)
	@PostMapping("/addMCD")
	public String addMCD(@RequestBody MCDModel mCDModel) {

		log.info("MCD add request recived ={}", mCDModel);
		return mCDService.addMCD(mCDModel);

	}

	@ApiOperation(value = "MCD update Api", response = String.class)
	@PostMapping("/updateMCD")
	public String updateMCD(@RequestBody MCDModel mCDModel) {

		log.info("MCD add request recived ={}", mCDModel);
		return mCDService.updateMCD(mCDModel);
	}

	@ApiOperation(value = "MCD update Api", response = String.class)
	@PostMapping("/deleteMCD")
	public String deleteMCD(@RequestParam("id") String id) {

		log.info("MCD delete request recived ={}", id);
		return mCDService.deleteMCD(id);
	}

	@ApiOperation(value = "All MCD Details Api", response = MCDModel.class)
	@PostMapping("/getAllMCD")
	public MappingJacksonValue getAll() {

		log.info("MCD get all details request request recived ");

		List<MCDModel> response = mCDService.getAllDetails();

		log.info("Response send ={}", response);
		MappingJacksonValue mapping = new MappingJacksonValue(response);

		return mapping;

	}

}
