package org.gleplant.herdManager.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.gleplant.herdManager.bo.Race;

public class RaceDAOJDBCImpl {

	public static List<Race> selectAll() {
		List<Race> results = new ArrayList<Race>();

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM race");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Race currentRace = new Race(rs.getInt("race_id"), rs.getString("raceName"));
				results.add(currentRace);
			}
			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return results;
	}

	public static int insert(Race newRace) {
		int result = -1;

		try {
			Connection conn = DatabaseConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement("INSERT INTO race (raceName , race_id) VALUES (?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, newRace.getName());
			ps.setInt(2, newRace.getRaceId());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next()) {
				result = rs.getInt(1);
			}

			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void update(Race updatedRace) {

		try {
			Connection conn = DatabaseConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement("UPDATE race SET raceName=?  WHERE race_id=?");
			ps.setString(1, updatedRace.getName());
			ps.setInt(2, updatedRace.getRaceId());

			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void deleteById(int id) {

		try {
			Connection conn = DatabaseConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement("DELETE FROM race WHERE race_id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
