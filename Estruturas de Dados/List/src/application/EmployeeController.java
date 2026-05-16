package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entity.Employee;

public class EmployeeController {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		ex1();

	}

	private static void ex1() {

		List<Employee> employees = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			System.out.println("\n#Employee " + (i + 1) + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			employees.add(new Employee(id, name, salary));
			
		}
		
		System.out.print("Enter the employee id tha will have salary increase: ");
		int idEmployee = sc.nextInt();
		
		if (employees.stream().anyMatch(x -> x.getId() == idEmployee)) {
			
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			
			
			employees.stream()
			.filter(x -> x.getId() == idEmployee)
			.findFirst()
			.ifPresent(x -> x.increaseSalary(percentage));
			
		} else {
			System.out.println("Employee not found.");
			return;
		}
		
		for (Employee e : employees) {
			
			System.out.println(e);
			
		}

	}

}
