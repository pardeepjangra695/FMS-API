package com.trainer.FMS_API.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainer.FMS_API.Email.EmailUtil;
import com.trainer.FMS_API.Model.GuiLoginRequest;
import com.trainer.FMS_API.Model.GuiLoginResponse;
import com.trainer.FMS_API.Model.UpdatePasswordRequest;
import com.trainer.FMS_API.Repo.GuiUserRepo;

@Service
public class GuiUserService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	GuiUserRepo guiUserRepo;

	@Autowired
	EmailUtil emailUtil;

	public GuiLoginResponse login(GuiLoginRequest guiLoginRequest) {
		GuiLoginResponse guiLoginResponse = null;
		try {
			log.info("Request at service ={}", guiLoginRequest);
			String id = guiUserRepo.getUser(guiLoginRequest);
			if (id != null) {
				guiLoginResponse = new GuiLoginResponse(id, "SUCCESS");
			} else {
				guiLoginResponse = new GuiLoginResponse("0", "FAIL");
			}
		} catch (Exception e) {
			log.info("Exception found in login service={}", e.getMessage());
		}
		return guiLoginResponse;
	}

	public String updatePasswordRequest(UpdatePasswordRequest updatePasswordRequest) {
		String status = null;
		try {
			int UpdateStatus = guiUserRepo.updatePassword(updatePasswordRequest);
			if (UpdateStatus == 1) {
				status = "SUCCESS";
			} else {
				status = "FAIL";
			}
		} catch (Exception e) {
			log.info("Exception found in Password Chnage ={}", e.getMessage());
		}
		log.info("Update Status Resonse ={}", status);
		return status;
	}

	public String createUser(GuiLoginRequest guiLoginRequest) {
		String status = null;
		try {
			int result = guiUserRepo.insertUserDetails(guiLoginRequest);
			if (result == 1)
				status = "SUCCESS";
			else
				status = "FAIL";

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception foung create user ={}", e.getMessage());
			status = "FAIL";

		}
		log.info("Create user Response is ={}", status);
		return status;
	}

	public String forgottenPassword(String userName) {
		try {
			/*String id = guiUserRepo.getUserDetails(userName);

			if (id == null) {
				return "UserNamr not exist.";
			} else {*/

				boolean status = emailUtil.sendEmail(userName, "jangrapardeep695@gmail.com", "ForgotenPassword",
						"LINK");
				if (status)
					return "Success";
				else
					return "Mail not sent";
			//}

		} catch (Exception e) {
			log.info("Exception found in forgotten Password={}", e.getMessage());
		}
		return null;
	}

}
