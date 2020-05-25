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

import com.trainer.FMS_API.Model.ZoneModel;

@Repository
public class ZoneRepo {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public int addZone(ZoneModel zone) {
		try {
			String query = "insert into zone (zone_name,zone_code,mcd ,status) values(?,?,?,?)";
			log.info(query);
			return jdbcTemplate.update(query,
					new Object[] { zone.getZoneName(), zone.getZoneCode(), zone.getMcd(), 1 });

		} catch (Exception e) {
			log.info("Exception found in add zone={}", e.getMessage());
		}
		return 0;
	}

	public int updateZone(ZoneModel zone) {
		try {
			String query = "update zone set zone_name=?,zone_code=?,mcd=? where id =?";
			log.info(query);
			return jdbcTemplate.update(query,
					new Object[] { zone.getZoneName(), zone.getZoneCode(), zone.getMcd(), zone.getId() });

		} catch (Exception e) {
			log.info("Exception found in update zone={}", e.getMessage());
		}
		return 0;
	}

	public int deleteZone(String id) {
		try {
			String query = "delete from zone where id =?";
			log.info(query);
			return jdbcTemplate.update(query, new Object[] { id });

		} catch (Exception e) {
			log.info("Exception found in update zone={}", e.getMessage());
		}
		return 0;
	}

	public List<ZoneModel> getAllZone() {
		try {
			String query = "select id,zone_name,zone_code, mcd,createdOn,updatedOn from zone where status =1";
			log.info(query);
			return jdbcTemplate.query(query, zonedetailsMapper);

		} catch (Exception e) {
			log.info("Exception found in update zone={}", e.getMessage());
		}
		return null;
	}

	private final RowMapper<ZoneModel> zonedetailsMapper = new RowMapper<ZoneModel>() {

		public ZoneModel mapRow(ResultSet rs, int i) throws SQLException {

			ZoneModel zoneModel = new ZoneModel();
			zoneModel.setId(rs.getInt("id"));
			zoneModel.setCreatedOn(rs.getString("createdOn"));
			zoneModel.setUpdatedOn(rs.getString("updatedOn"));
			zoneModel.setMcd(rs.getString("mcd"));
			zoneModel.setZoneCode(rs.getString("zone_code"));
			zoneModel.setZoneName(rs.getString("zone_name"));

			return zoneModel;
		}
	};

}
