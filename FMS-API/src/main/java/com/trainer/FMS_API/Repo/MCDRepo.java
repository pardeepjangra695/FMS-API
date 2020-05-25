package com.trainer.FMS_API.Repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.trainer.FMS_API.Model.MCDModel;

@Repository
public class MCDRepo {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public int addMCD(MCDModel mCDModel) {
		try {
			String query = "insert into mcd (mcd_name,mcd_code,state,status) values(?,?,?,?)";
			log.info(query);
			return jdbcTemplate.update(query,
					new Object[] { mCDModel.getMcdName(), mCDModel.getMcdCode(), mCDModel.getState(), 1 });

		} catch (Exception e) {
			log.info("Exception found in add mcd={}", e.getMessage());
		}

		return 0;
	}

	public int updateMCD(MCDModel mCDModel) {
		try {
			String query = "update mcd set mcd_name =?,mcd_code=?,state=? where id =? ";
			log.info(query);
			return jdbcTemplate.update(query, new Object[] { mCDModel.getMcdName(), mCDModel.getMcdCode(),
					mCDModel.getState(), mCDModel.getId() });

		} catch (Exception e) {
			log.info("Exception found in add mcd={}", e.getMessage());
		}

		return 0;
	}

	public int deleteMCD(String id) {
		try {
			String query = "delete  from mcd where id =? ";
			log.info(query);
			return jdbcTemplate.update(query, new Object[] { id });

		} catch (Exception e) {
			log.info("Exception found in add mcd={}", e.getMessage());
		}
		return 0;
	}

	public List<MCDModel> getAllMCD() {
		try {

			String query = "select mcd_name, mcd_code, state,id ,createdOn,updatedOn from mcd where status =1 ";
			log.info(query);
			return jdbcTemplate.query(query, mCDdetailsMapper);
		} catch (EmptyResultDataAccessException e) {
			log.info("Data not present in db ={}", e.getMessage());
		}
		return null;
	}

	private final RowMapper<MCDModel> mCDdetailsMapper = new RowMapper<MCDModel>() {

		public MCDModel mapRow(ResultSet rs, int i) throws SQLException {

			MCDModel mCDModel = new MCDModel();
			mCDModel.setId(rs.getInt("id"));
			mCDModel.setMcdCode(rs.getString("mcd_code"));
			mCDModel.setMcdName(rs.getString("mcd_name"));
			mCDModel.setState(rs.getString("state"));
			mCDModel.setCreatedOn(rs.getString("createdOn"));
			mCDModel.setUpdatedOn(rs.getString("updatedOn"));
			return mCDModel;
		}
	};

}
