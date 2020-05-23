package com.trainer.FMS_API.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.trainer.FMS_API.Model.ASGModel;
import com.trainer.FMS_API.Model.TeachersModel;
import com.trainer.FMS_API.Model.UserLoginRequest;
import com.trainer.FMS_API.Model.UserLoginResponse;
import com.trainer.FMS_API.Repo.ASGRepo;
import com.trainer.FMS_API.Repo.TeachersRepo;

@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	ASGRepo asgRepo;

	@Autowired
	TeachersRepo teachersRepo;

	public UserLoginResponse getUserDetails(UserLoginRequest userLoginRequest) {
		try {
			UserLoginResponse response = null;
			log.info("User deatils fetch request recive ={}", userLoginRequest);
			ASGModel asgModel = asgRepo.getASGDetails(userLoginRequest.getMsisdn());

			if (asgModel == null) {
				TeachersModel model = teachersRepo.getTeachersDetails(userLoginRequest.getMsisdn());
				if (model == null) {
					response = new UserLoginResponse(null, null, null, null, null, null, null, true);
					return response;
				} else {
					response = new UserLoginResponse(model.getTeacherName(), model.getMobile(), model.getEmial(),
							model.getSubject(), model.getSchool(), null, model.getTxnId(), false);

					teachersRepo.updateUserDetails(userLoginRequest.getOsUser(), userLoginRequest.getFcmId(),
							userLoginRequest.getMsisdn());

					return response;
				}
			} else {
				response = new UserLoginResponse(asgModel.getAsgName(), asgModel.getMobile(), asgModel.getEmail(),
						asgModel.getSubject(), null, asgModel.getZone(), asgModel.getTxnId(), false);
				asgRepo.updateUserDetails(userLoginRequest.getOsUser(), userLoginRequest.getFcmId(),
						userLoginRequest.getMsisdn());

				return response;
			}

		} catch (Exception e) {
			log.info("Exection found={}", e.getMessage());
		}
		return null;
	}

}
