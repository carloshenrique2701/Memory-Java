package application;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===Teste 1: Department findById===");
		Department d1 = departmentDao.findById(8);
		System.out.println(d1);

		System.out.println("\n===Teste 2: Department findAll===");
		List<Department> d2 = departmentDao.findAll();
		for (Department d : d2) {
			System.out.println(d);
		}
		
		System.out.println("\n===Teste 3: Department insert===");
		Department d3 = new Department(null, "school supplies");
		departmentDao.insert(d3);
		System.out.println("Inserted! New id: " + d3.getId());
		
		System.out.println("\n===Teste 4: Department update===");
		d3 = departmentDao.findById(8);
		d3.setName("Office");
		departmentDao.update(d3);
		System.out.println("Updated!");

		System.out.println("\n===Teste 5: Department delete===");
		System.out.print("Enter a id for delete: ");
		departmentDao.deleteById(sc.nextInt());
		System.out.println("Deleted");
		
		sc.close();
		
	}

}
