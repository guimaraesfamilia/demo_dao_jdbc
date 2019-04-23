package com.model.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DB {

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
