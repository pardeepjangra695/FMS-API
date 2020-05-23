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

import com.trainer.FMS_API.Model.TeachersModel;

@Repository
public class TeachersRepo {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	private final Logger log = LoggerFactory.getLogger(getClass());

	public TeachersModel getTeachersDetails(String msisdn) {
		try {
			String query = "select teacher_name,email,msisdn,subject,school,createdOn,updatedOn,txn_id from teachers where msisdn =?";
			log.info("Select Query={}", query);

			return jdbcTemplate.queryForObject(query, new Object[] { msisdn }, teacherdetailsMapper);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int updateUserDetails(String osType, String fcmId, String msisdn) {
		try {
			String query = "update teachers set os_type=? ,fcm_id =? where msisdn=?";
			log.info("update teachers set os_type='" + osType + "',fcm_id ='" + fcmId + "' where msisdn='" + msisdn
					+ "'");
			return jdbcTemplate.update(query, new Object[] { osType, fcmId, msisdn });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	private final RowMapper<TeachersModel> teacherdetailsMapper = new RowMapper<TeachersModel>() {

		public TeachersModel mapRow(ResultSet rs, int i) throws SQLException {

			TeachersModel aSGsDetails = new TeachersModel();
			aSGsDetails.setTeacherName(rs.getString("teacher_name"));
			aSGsDetails.setCreatedon(rs.getString("createdOn"));
			aSGsDetails.setEmial(rs.getString("email"));
			aSGsDetails.setMobile(rs.getString("msisdn"));
			aSGsDetails.setModifiedon(rs.getString("updatedOn"));
			aSGsDetails.setSubject(rs.getString("subject"));
			aSGsDetails.setSchool(rs.getString("school"));
			aSGsDetails.setTxnId(rs.getString("txn_id"));
			return aSGsDetails;
		}
	};

}
