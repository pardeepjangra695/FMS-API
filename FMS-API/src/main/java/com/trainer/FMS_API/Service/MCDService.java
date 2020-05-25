package com.trainer.FMS_API.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainer.FMS_API.Model.MCDModel;
import com.trainer.FMS_API.Repo.MCDRepo;

@Service
public class MCDService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	MCDRepo mCDRepo;

	public String addMCD(MCDModel mCDModel) {
		try {

			int state = mCDRepo.addMCD(mCDModel);
			if (state == 1)
				return "Success";
		} catch (Exception e) {
			log.info("Exception found in add user ={}", e.getMessage());
		}

		return "Fail";
	}

	public String updateMCD(MCDModel mCDModel) {
		try {

			int state = mCDRepo.updateMCD(mCDModel);
			if (state == 1)
				return "Success";
		} catch (Exception e) {
			log.info("Exception found in update user ={}", e.getMessage());
		}

		return "Fail";
	}

	public String deleteMCD(String id) {
		try {

			int state = mCDRepo.deleteMCD(id);
			if (state == 1)
				return "Success";
		} catch (Exception e) {
			log.info("Exception found in delete user ={}", e.getMessage());
		}

		return "Fail";
	}

	public List<MCDModel> getAllDetails() {
		try {
			return mCDRepo.getAllMCD();
		} catch (Exception e) {
			log.info("Exception found in fet details ={}", e.getMessage());
		}

		return null;
	}

}
