package com.model.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.db.DB;
import com.model.db.DbException;
import com.model.services.IOperationsCrud;

public class Department implements IOperationsCrud {

	private Connection conn = null;

	private String name;

	public Department() {
		super();
	}

	public Department(String name) {
		super();
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int insert() {

		int rowsaffect = 0;
		PreparedStatement pst = null;

		try {

			conn = DB.getConnection();
			conn.setAutoCommit(false);

			pst = conn.prepareStatement(

					"insert into department (Name)values(?)"

			);
			pst.setString(1, this.getName());

			if (this.getName().equals("")) {

				throw new SQLException("Field is not a null");
			}

			rowsaffect = pst.executeUpdate();
			conn.commit();

		} catch (SQLException e) {

			try {
				conn.rollback();
				System.out.println("Transation rollback! Cause: " + e.getMessage());

			} catch (SQLException e1) {

				System.out.println("Trying rollback failed. Cause: " + e1.getMessage());
			}

			throw new DbException(e.getMessage());
		}

		return rowsaffect;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {

		int rowsaffected = 0;

		PreparedStatement pst = null;

		try {

			conn = DB.getConnection();
			conn.setAutoCommit(false);
			pst = conn.prepareStatement("delete from department where Id = (?)");

			pst.setInt(1, id);
			rowsaffected = pst.executeUpdate();

			conn.commit();

		} catch (SQLException e) {

			try {
				conn.rollback();

				throw new SQLException("Transation is rollback! Cause :" + e.getMessage());

			} catch (SQLException e1) {

				System.out.println("Rollback is traying failed. Cause: " + e1.getMessage());

			}

			throw new DbException(e.getMessage());
		}

		return rowsaffected;
	}

	@Override
	public void list() {

		Statement st = null;
		ResultSet rs = null;

		try {

			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from department");

			while (rs.next()) {

				System.out.println("  " + rs.getInt("Id") + " - " + rs.getString("Name"));
			}

		} catch (SQLException e) {

			throw new DbException(e.getMessage());
		}

	}

}
