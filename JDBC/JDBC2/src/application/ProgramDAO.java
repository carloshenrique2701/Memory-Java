package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbIntegrityException;

@SuppressWarnings("unused")
public class ProgramDAO {
	
	public ProgramDAO() {
	}

	public void deleteSeller() {

		Connection conn = null;
		PreparedStatement st = null;

		try {

			conn = DB.getConnection();

			st = conn.prepareStatement("DELETE FROM department " + " WHERE " + " Id = ?");

			st.setInt(1, 5);

			int rowsAffected = st.executeUpdate();

			System.out.println("Done! Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	public void updateSeller() {

		Connection conn = null;
		PreparedStatement st = null;

		try {

			conn = DB.getConnection();
			st = conn.prepareStatement(
					"Update seller " + " SET BaseSalary = BaseSalary + ? " + " WHERE " + " (DepartmentId = ?)");

			st.setDouble(1, 200.00);
			st.setInt(2, 1);

			int rowsAffected = st.executeUpdate();

			System.out.println("Done! Rows Affected: " + rowsAffected);

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	public void readDepartments() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * from department");

			while (rs.next()) {

				System.out.println(rs.getInt("Id") + " | " + rs.getString("Name"));

			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			DB.closeConnection();
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	public void setNewSellerOrDepartment() {
		Connection conn = null;
		PreparedStatement st = null;

		try {

			

			conn = DB.getConnection();
			/*
			SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
			 
			//Adiciona vendedor 
			st = conn.prepareStatement( 
			"INSERT INTO seller " +
			"(Name, Email, BirthDate, BaseSalary, DepartmentId) " 
			+ "Values" +
			"(?, ?, ?, ?, ?)", 
			Statement.RETURN_GENERATED_KEYS);
			 
			st.setString(1, "Zé Lucas"); 
			st.setString(2, "ze@gmail.com"); 
			st.setDate(3, new java.sql.Date(sdt.parse("17/11/1993").getTime()));
			st.setDouble(4, 2500.0); 
			st.setDouble(5, 1);
			 */

			// Adiciona departamento
			st = conn.prepareStatement("INSERT INTO department (Name) VALUES ('D1'),('D2')",
					Statement.RETURN_GENERATED_KEYS);

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! new id: " + id + "\n");
				}
			} else {
				System.out.println("Done! Rows affected: " + rowsAffected + "\n");
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} /*
			 * catch (ParseException e) { //Para adicionar um vendedor precisa desse catch
			 * por conta do Date(); System.out.println("Error: " + e.getMessage()); }
			 */finally {
			DB.closeStatement(st);
		}
	}

	public void readSellers() {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			conn = DB.getConnection();

			st = conn.createStatement();

			rs = st.executeQuery(
					"" + "select s.*, d.name dName" + " from seller s, department d " + " where d.Id = s.DepartmentId");

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("email")
						+ " | " + rs.getDate("BirthDate") + " | " + String.format("%.2f", rs.getDouble("BaseSalary"))
						+ " | " + rs.getString("dName"));

			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
