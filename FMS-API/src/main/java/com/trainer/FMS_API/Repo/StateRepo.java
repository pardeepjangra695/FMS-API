package com.trainer.FMS_API.Repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

	public int updateState(StateModel stateModel) {

		try {
			String query = "update state set state_name= ?, state_code= ? where id = ? ";
			log.info(query);
			return jdbcTemplate.update(query,
					new Object[] { stateModel.getStateName(), stateModel.getStateCode(), stateModel.getId() });
		} catch (Exception e) {
			log.info("Exception foudn in to add the state ={}", e.getMessage());
		}
		return 0;
	}

	public int deleteState(int id) {
		try {
			String query = "delete from state where id = ?";
			log.info(query);
			return jdbcTemplate.update(query, new Object[] { id });
		} catch (Exception e) {
			log.info("Exception foudn in to add the state ={}", e.getMessage());
		}
		return 0;
	}

	public List<StateModel> getAllState() {
		try {
			String query = "select state_name,state_code, id,createdOn,updatedOn from state where status = ?";
			log.info(query);
			return jdbcTemplate.query(query, new Object[] { 1 }, statedetailsMapper);
		} catch (Exception e) {
			log.info("Exception foudn in to add the state ={}", e.getMessage());
		}
		return null;
	}

	private final RowMapper<StateModel> statedetailsMapper = new RowMapper<StateModel>() {

		public StateModel mapRow(ResultSet rs, int i) throws SQLException {

			StateModel stateModel = new StateModel();
			stateModel.setId(rs.getInt("id"));
			stateModel.setStateCode(rs.getString("state_code"));
			stateModel.setStateName(rs.getString("state_name"));
			stateModel.setCreatedOn(rs.getString("createdOn"));
			stateModel.setUpdatedOn(rs.getString("updatedOn"));
			return stateModel;
		}
	};

}
