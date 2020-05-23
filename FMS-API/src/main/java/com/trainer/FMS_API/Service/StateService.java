package com.trainer.FMS_API.Service;

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

}
