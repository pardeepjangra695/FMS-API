package com.trainer.FMS_API.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.trainer.FMS_API.Model.GuiLoginRequest;
import com.trainer.FMS_API.Model.UpdatePasswordRequest;

@Repository
public class GuiUserRepo {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public String getUser(GuiLoginRequest GuiLoginRequest) {

		try {
			String query = " select id from gui_user where email=? and password =? and userType =? and status = 1";
			log.info(query);

			return jdbcTemplate.queryForObject(query, new Object[] { GuiLoginRequest.getEmial(),
					GuiLoginRequest.getPassword(), GuiLoginRequest.getUserType() }, String.class);
		} catch (EmptyResultDataAccessException e) {
			log.info("Exception found ={}", e.getMessage());
		}
		return null;
	}

	public int updatePassword(UpdatePasswordRequest updatePasswordRequest) {
		try {
			String query = "update gui_user set password =? where id =? ";
			log.info(query);

			return jdbcTemplate.update(query,
					new Object[] { updatePasswordRequest.getPassword(), updatePasswordRequest.getId() });
		} catch (Exception e) {
			log.info("Exception occure in execute the query ={}", e.getMessage());
		}
		return 0;
	}

	public int insertUserDetails(GuiLoginRequest guiLoginRequest) {
		try {
			String query = "insert into gui_user (email,password,userType,status,msisdn) values (?,?,?,?,?)";

			log.info(query);
			return jdbcTemplate.update(query, new Object[] { guiLoginRequest.getEmial(), guiLoginRequest.getPassword(),
					guiLoginRequest.getUserType(), 1, guiLoginRequest.getMsisdn() });

		} catch (Exception e) {
			log.info("Insert query found exception={}", e.getMessage());
		}
		return 0;

		/*
		 * KeyHolder holder = new GeneratedKeyHolder(); PreparedStatementCreator psc =
		 * new PreparedStatementCreator() { public PreparedStatement
		 * createPreparedStatement(final Connection connection) throws SQLException {
		 * PreparedStatement ps = connection.prepareStatement(query,
		 * Statement.RETURN_GENERATED_KEYS); ps.setString(1,
		 * guiLoginRequest.getEmial()); ps.setString(2, guiLoginRequest.getPassword());
		 * ps.setString(3, guiLoginRequest.getUserType()); ps.setInt(4, 1);
		 * ps.setLong(5, guiLoginRequest.getMsisdn());
		 * 
		 * return ps; } }; jdbcTemplate.update(psc, holder); return
		 * holder.getKey().intValue();
		 */

	}

	public String getUserDetails(String userName) {
		try {

			String query = "select id from gui_user where email =? ";
			log.info(query);
			return jdbcTemplate.queryForObject(query, new Object[] { userName }, String.class);

		} catch (EmptyResultDataAccessException e) {
			log.info("Exception found in userDetails={}", e.getMessage());
		}
		return null;
	}

}
