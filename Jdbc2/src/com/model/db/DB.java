package com.model.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	// Metodo para criar conexao com o banco de dados

	public static Connection getConnection() {

		if (conn == null) {

			try {

				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);

			} catch (SQLException e) {

				throw new DbException(e.getMessage());
			}

		}

		return conn;
	}

	// Metodo para fechar a conexao com o banco de dados

	public static void closeConnection() {

		try {

			if (conn != null) {

				conn.close();
			}
		} catch (SQLException e) {

			throw new DbException(e.getMessage());
		}
	}

	// Metodo para carregar as propriedades da conexao

	private static Properties loadProperties() {

		try (FileInputStream fs = new FileInputStream("db.properties")) {

			Properties props = new Properties();
			props.load(fs);
			return props;

		} catch (IOException e) {

			throw new DbException(e.getMessage());
		}

	}
}
