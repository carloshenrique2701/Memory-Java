package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String strLine;
			
			List<Employee> employees = new ArrayList<>();
			
			while((strLine = br.readLine()) != null) {
				
				String[] line = strLine.split(",");
				
				employees.add(new Employee(line[0], line[1], Double.parseDouble(line[2])));
				
			}
			
			System.out.print("\nEnter salary: ");
			double salary = sc.nextDouble();
			
			List<String> filtredEmployees = employees.stream()
					.filter(x -> x.getSalary() > salary)
					.map(e -> e.getEmail())
					.sorted((e1, e2) -> e1.toUpperCase().compareTo(e2.toUpperCase()))
					.collect(Collectors.toList());
			
			System.out.println("\nEmail of employees whose salary is more than " + String.format("%.2f", salary) + ": ");
			filtredEmployees.forEach(System.out::println);
			
			double sum = employees.stream()
					.filter(e -> e.getName().toUpperCase().charAt(0) == 'M')
					.map(Employee::getSalary)
					.reduce(0.0, (x, y) -> x + y);
			
			System.out.println("\nSum of salary of employee whose name starts with 'M': " + String.format("%.2f", sum));
					
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

}
