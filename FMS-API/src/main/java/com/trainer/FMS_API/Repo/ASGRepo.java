package com.trainer.FMS_API.Repo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.trainer.FMS_API.Model.ASGModel;

@Repository
public class ASGRepo {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public ASGModel getASGDetails(String msisdn) {
		try {
			String query = "select asg_name,email,msisdn,zone,subject,updatedOn,createdOn,txn_id from asg where msisdn = ? ";
			log.info("ASG Query={}", query);
			return jdbcTemplate.queryForObject(query, new Object[] { msisdn }, asgdetailsMapper);

		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public int updateUserDetails(String osType, String fcmId, String msisdn) {
		try {
			String query = "update asg set os_type=? ,fcm_id =? where msisdn=?";
			log.info("update asg set os_type='" + osType + "',fcm_id ='" + fcmId + "' where msisdn='" + msisdn
					+ "'");
			return jdbcTemplate.update(query, new Object[] { osType, fcmId, msisdn });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	private final RowMapper<ASGModel> asgdetailsMapper = new RowMapper<ASGModel>() {

		public ASGModel mapRow(ResultSet rs, int i) throws SQLException {

			ASGModel aSGsDetails = new ASGModel();
			aSGsDetails.setAsgName(rs.getString("asg_name"));
			aSGsDetails.setCreatedon(rs.getString("createdOn"));
			aSGsDetails.setEmail(rs.getString("email"));
			aSGsDetails.setMobile(rs.getString("msisdn"));
			aSGsDetails.setModifiedon(rs.getString("updatedOn"));
			aSGsDetails.setSubject(rs.getString("subject"));
			aSGsDetails.setZone(rs.getString("zone"));
			aSGsDetails.setTxnId(rs.getString("txn_id"));
			return aSGsDetails;
		}
	};

}
