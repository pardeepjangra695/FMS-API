package com.trainer.FMS_API.Repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trainer.FMS_API.Model.StateModel;

@Repository
public class StateRepo {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public int addState(StateModel stateModel) {
		try {

			String query = "insert into state (state_name,state_code,status) values(?,?,?)";
			log.info(query);
			return jdbcTemplate.update(query, new Object[] { stateModel.getStateName(), stateModel.getStateCode(), 1 });

		} catch (Exception e) {
			log.info("Exception foudn in to add the state ={}", e.getMessage());
		}

		return 0;

	}

}
