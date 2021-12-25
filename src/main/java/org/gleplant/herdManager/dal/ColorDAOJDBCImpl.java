package org.gleplant.herdManager.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.gleplant.herdManager.bo.Color;

public class ColorDAOJDBCImpl {
	public static List<Color> selectAll() {
		List<Color> results = new ArrayList<Color>();

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM color");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Color currentColor = new Color(rs.getInt("color_id"), rs.getString("colorName"));
				results.add(currentColor);
			}
			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return results;
	}

	public static int insert(Color newColor) {
		int result = -1;

		try {
			Connection conn = DatabaseConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement("INSERT INTO clor (colorName , color_id) VALUES (?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, newColor.getName());
			ps.setInt(2, newColor.getColorId());

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

	public static void update(Color updatedColor) {

		try {
			Connection conn = DatabaseConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement("UPDATE color SET colorName=?  WHERE color_id=?");
			ps.setString(1, updatedColor.getName());
			ps.setInt(2, updatedColor.getColorId());

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

			PreparedStatement ps = conn.prepareStatement("DELETE FROM color WHERE color_id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
