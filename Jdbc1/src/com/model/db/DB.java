package com.model.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection() {

		try {

			Properties props = loadProperites();
			String url = props.getProperty("dburl");

			conn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {

			throw new DbExecption(e.getMessage());
		}

		return conn;

	}

	public static void closeConnection() {

	}

	public static Properties loadProperites() {

		try (FileInputStream fs = new FileInputStream("db.properties")) {

			Properties props = new Properties();
			props.load(fs);
			return props;

		} catch (IOException e) {

			throw new DbExecption(e.getMessage());

		}
	}

}
