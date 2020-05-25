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

import com.trainer.FMS_API.Model.ZoneModel;
import com.trainer.FMS_API.Service.ZoneService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ZoneController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	ZoneService zoneService;

	@ApiOperation(value = "Zone ADD Api", response = String.class)
	@PostMapping("/addZone")
	public String addState(@RequestBody ZoneModel zone) {

		log.info("Zone add request recived ={}", zone);
		return zoneService.addZone(zone);

	}

	@ApiOperation(value = "Zone Update Api", response = String.class)
	@PostMapping("/updateZone")
	public String updateState(@RequestBody ZoneModel zone) {

		log.info("Zone update request recived ={}", zone);
		return zoneService.updateZone(zone);

	}

	@ApiOperation(value = "Zone Delete Api", response = String.class)
	@GetMapping("/deleteZone")
	public String deleteState(@RequestParam("id") String id) {

		log.info("Zone delete request recived ={}", id);
		return zoneService.deleteZone(id);

	}

	@ApiOperation(value = "All Zone details Api", response = ZoneModel.class)
	@PostMapping("/getAllZone")
	public MappingJacksonValue getState() {

		log.info("Zone get details request recived");
		List<ZoneModel> response = zoneService.getAllZone();

		log.info("Zone Response send is ={}", response);
		MappingJacksonValue mapping = new MappingJacksonValue(response);

		return mapping;
	}

}
