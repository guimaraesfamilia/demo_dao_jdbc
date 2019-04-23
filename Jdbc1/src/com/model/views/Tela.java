package com.model.views;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.model.db.DB;
//import com.model.db.DbExecption;

public class Tela {

	private static Scanner sc = new Scanner(System.in);
	private static Connection conn = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	public static void mainProgram() {

		proced_1();
		sc.close();
	}

	private static void proced_1() {

		try {

			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from department");

			while (rs.next()) {

				System.out.println(rs.getInt("Id") + "," + rs.getNString("Name"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}