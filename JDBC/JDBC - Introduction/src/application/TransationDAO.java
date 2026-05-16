package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class TransationDAO {

	public TransationDAO() {
	}

	//  Dessa forma, caso dê um erro somente uma consulta é realizada no BD e isso pode
	//gerar um problema de inconsistência quebrando o banco de dados a depender das consultas
	//  O transation2, demonstra como realizar as duas de uma única vez, se der problema em uma,
	//nunhuma é executada;	
	public void transation1() {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate(
					"UPDATE seller "
					+ "SET BaseSalary = 2090 "
					+ "WHERE DepartmentId = 1");
			
			int x = 1;
			if (x < 2) {
				throw new SQLException("Fake error");
			}
			
			int rows2 = st.executeUpdate(
					"UPDATE seller "
					+ "SET BaseSalary = 3090 "
					+ "WHERE DepartmentId = 2");
			
			System.out.println("Rows1: " + rows1);
			System.out.println("Rows2: " + rows2);
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
		
	}
	
	public void transation2() {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);//Impede de executar as consultas dinâmicamente e fica a depender de uma confirmação
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate(
					"UPDATE seller "
					+ "SET BaseSalary = 4120 "
					+ "WHERE DepartmentId = 1");
			/*//Erro fake para demonstração
			int x = 1;
			if (x < 2) {
				throw new SQLException("Fake error");
			}
			*/
			int rows2 = st.executeUpdate(
					"UPDATE seller "
					+ "SET BaseSalary = 3090 "
					+ "WHERE DepartmentId = 2");
			
			conn.commit();//Confirma a execução das consultas
			
			System.out.println("Rows1: " + rows1);
			System.out.println("Rows2: " + rows2);
			
		} catch (SQLException e) {
			try {
				conn.rollback(); //Dá roolback no BD caso aconteça algum erro
				throw new DbException("Transation rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		} finally {
			DB.closeStatement(st);
		}
		
	}
}
