package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import modal.entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);

		List<Employee> list = new ArrayList<>();
		String path = "file.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String csvContent = br.readLine();

			while (csvContent != null) {
				String[] fields = csvContent.split(",");
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				csvContent = br.readLine();
			}

			Collections.sort(list);

			for (Employee emp : list) {
				System.out.println(emp.getName() + ", " + String.format("%.2f", emp.getSalary()));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
