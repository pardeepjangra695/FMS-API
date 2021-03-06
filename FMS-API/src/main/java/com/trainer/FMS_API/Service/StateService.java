package com.trainer.FMS_API.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainer.FMS_API.Model.StateModel;
import com.trainer.FMS_API.Repo.StateRepo;

@Service
public class StateService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	StateRepo stateRepo;

	public String addState(StateModel stateModel) {
		try {

			int state = stateRepo.addState(stateModel);
			if (state == 1)
				return "Success";
		} catch (Exception e) {
			log.info("Exception found in add user ={}", e.getMessage());
		}

		return "Fail";
	}

	public String updateState(StateModel stateModel) {
		try {

			int state = stateRepo.updateState(stateModel);
			if (state == 1)
				return "Success";
		} catch (Exception e) {
			log.info("Exception found in add user ={}", e.getMessage());
		}
		return "Fail";
	}

	public String deleteState(int id) {
		try {

			int state = stateRepo.deleteState(id);
			if (state == 1)
				return "Success";
		} catch (Exception e) {
			log.info("Exception found in add user ={}", e.getMessage());
		}
		return "Fail";
	}

	public List<StateModel> getAllState() {
		try {
			List<StateModel> list = stateRepo.getAllState();
			return list;
		} catch (Exception e) {
			log.info("Exception found in get state ={}", e.getMessage());
		}
		return null;
	}

}
