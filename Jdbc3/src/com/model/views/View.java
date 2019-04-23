package com.model.views;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.db.DB;


public class View {

	private static Connection conn = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	public static void mainProgram() {

		procedment_1();
	}

	private static void procedment_1() {

		try {

			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from department");

			while (rs.next()) {

				System.out.println(rs.getInt("Id") + "," + rs.getString("Name"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
