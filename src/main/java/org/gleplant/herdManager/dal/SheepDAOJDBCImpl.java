package org.gleplant.herdManager.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.gleplant.herdManager.bo.Color;
import org.gleplant.herdManager.bo.Race;
import org.gleplant.herdManager.bo.Sheep;

public class SheepDAOJDBCImpl {

	public static LocalDateTime getFormattedBirthDate(String strToFormat) {
		if (!strToFormat.equals("")) {
			return LocalDateTime.parse(strToFormat, DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss"));
		} else {
			return LocalDateTime.MIN;
		}
	}

	public static List<Sheep> selectAll() {
		List<Sheep> results = new ArrayList<Sheep>();

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM sheep as sh JOIN color c ON sh.color_id=c.color_id JOIN race r ON sh.race_id=r.race_id");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Race currentRace = new Race(rs.getInt("race_id"), rs.getString("raceName"));

				Color currentColor = new Color(rs.getInt("color_id"), rs.getString("colorName"));

				Sheep currentSheep = new Sheep(currentColor, currentRace, rs.getInt("gender"),
						getFormattedBirthDate(rs.getString("birth_date")), rs.getString("comments"),
						rs.getString("nom"), rs.getString("registration_number"),
						rs.getString("mother_registration_number"), rs.getString("father_registration_number"),
						rs.getInt("photo_number"), rs.getString("firstname"), rs.getInt("birth_year"),
						rs.getInt("sheep_id"));
				results.add(currentSheep);
			}
			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return results;
	}

	public static List<Sheep> selectByName(String strToSearchFor) {
		List<Sheep> results = new ArrayList<Sheep>();

		try {
			Connection conn = DatabaseConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM sheep as sh JOIN color c ON sh.color_id=c.color_id JOIN race r ON sh.race_id=r.race_id WHERE nom LIKE ?");
			ps.setString(1, strToSearchFor + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Race currentRace = new Race(rs.getInt("race_id"), rs.getString("raceName"));

				Color currentColor = new Color(rs.getInt("color_id"), rs.getString("colorName"));

				Sheep currentSheep = new Sheep(currentColor, currentRace, rs.getInt("gender"),
						getFormattedBirthDate(rs.getString("birth_date")), rs.getString("comments"),
						rs.getString("nom"), rs.getString("registration_number"),
						rs.getString("mother_registration_number"), rs.getString("father_registration_number"),
						rs.getInt("photo_number"), rs.getString("firstname"), rs.getInt("birth_year"),
						rs.getInt("sheep_id"));
				results.add(currentSheep);
			}

			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return results;
	}

	public static Sheep selectById(int id) {
		Sheep result = null;

		try {
			Connection conn = DatabaseConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM sheep as sh JOIN color c ON sh.color_id=c.color_id JOIN race r ON sh.race_id=r.race_id WHERE sheep_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Race currentRace = new Race(rs.getInt("race_id"), rs.getString("raceName"));

				Color currentColor = new Color(rs.getInt("color_id"), rs.getString("colorName"));
				result = new Sheep(currentColor, currentRace, rs.getInt("gender"),
						getFormattedBirthDate(rs.getString("birth_date")), rs.getString("comments"),
						rs.getString("nom"), rs.getString("registration_number"),
						rs.getString("mother_registration_number"), rs.getString("father_registration_number"),
						rs.getInt("photo_number"), rs.getString("firstname"), rs.getInt("birth_year"),
						rs.getInt("sheep_id"));
			}

			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static int insert(Sheep newSheep) {
		int result = -1;

		try {
			Connection conn = DatabaseConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO sheep (color_id, race_id, gender, birth_date, comments, nom, registration_number,mother_registration_number,"
							+ "father_registration_number,photo_number,firstname,birth_year,sheep_id) VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, newSheep.getColor().getColorId());
			ps.setInt(2, newSheep.getRace().getRaceId());
			ps.setInt(3, newSheep.getGender());
			ps.setString(4, newSheep.getBirthDate().toString());
			ps.setString(5, newSheep.getComments());
			ps.setString(6, newSheep.getName());
			ps.setString(7, newSheep.getRegistationNumber());
			ps.setString(8, newSheep.getMotherRegistrationNumber());
			ps.setString(9, newSheep.getFatherRegistrationNumber());
			ps.setInt(10, newSheep.getPhotoNumber());
			ps.setString(11, newSheep.getAlias());
			ps.setInt(12, newSheep.getBirthYear());
			ps.setInt(13, newSheep.getSheepId());

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

	public static void update(Sheep updatedSheep) {

		try {
			Connection conn = DatabaseConnection.getConnection();

			PreparedStatement ps = conn
					.prepareStatement("UPDATE sheep SET color_id=?, race_id=?, gender=?, birth_date=?, comments=?,"
							+ " nom=?, registration_number=?,mother_registration_number=?,father_registration_number,"
							+ " photo_number=?, firstname=?, birth_year=?" + " WHERE sheep_id=?");
			ps.setInt(1, updatedSheep.getColor().getColorId());
			ps.setInt(2, updatedSheep.getRace().getRaceId());
			ps.setInt(3, updatedSheep.getGender());
			ps.setString(4, updatedSheep.getBirthDate().toString());
			ps.setString(5, updatedSheep.getComments());
			ps.setString(6, updatedSheep.getName());
			ps.setString(7, updatedSheep.getRegistationNumber());
			ps.setString(8, updatedSheep.getMotherRegistrationNumber());
			ps.setString(9, updatedSheep.getFatherRegistrationNumber());
			ps.setInt(10, updatedSheep.getPhotoNumber());
			ps.setString(11, updatedSheep.getAlias());
			ps.setInt(12, updatedSheep.getBirthYear());
			ps.setInt(13, updatedSheep.getSheepId());

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

			PreparedStatement ps = conn.prepareStatement("DELETE FROM sheep WHERE sheep_id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
