package com.trainer.FMS_API.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainer.FMS_API.Model.ZoneModel;
import com.trainer.FMS_API.Repo.ZoneRepo;

@Service
public class ZoneService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	ZoneRepo zoneRepo;

	public String addZone(ZoneModel zone) {
		try {

			int status = zoneRepo.addZone(zone);
			if (status == 1)
				return "Success";

		} catch (Exception e) {
			log.info("Exception found in add zone ={}", e.getMessage());
		}

		return "Fail";
	}

	public String updateZone(ZoneModel zone) {
		try {
			int status = zoneRepo.updateZone(zone);
			if (status == 1)
				return "Success";

		} catch (Exception e) {
			log.info("Exception found in update zone ={}", e.getMessage());
		}

		return "Fail";
	}

	public String deleteZone(String id) {
		try {
			int status = zoneRepo.deleteZone(id);
			if (status == 1)
				return "Success";

		} catch (Exception e) {
			log.info("Exception found in update zone ={}", e.getMessage());
		}

		return "Fail";
	}

	public List<ZoneModel> getAllZone() {
		try {
			return zoneRepo.getAllZone();

		} catch (Exception e) {
			log.info("Exception found in select  zone ={}", e.getMessage());
		}

		return null;
	}

}
