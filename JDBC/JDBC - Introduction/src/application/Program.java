package application;

import java.util.Locale;

import db.DbException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		ProgramDAO p = new ProgramDAO();
		TransationDAO t = new TransationDAO();
		
		try {
			t.transation2();
			p.readSellers();
		} catch (DbException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

	
}
