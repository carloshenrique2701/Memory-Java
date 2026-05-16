package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Product;
import model.service.CalculatorService;
import model.service.PrintServiceGeneric;

public class Program {
	public static void main(String[] args) {

		delimitedGneric();
		
	}

	private static void delimitedGneric() {

		List<Product> list = new ArrayList<>();
		
		String path = "file.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while(line != null) {
				String[] product = line.split(",");
				list.add(new Product(product[0], Double.parseDouble(product[1])));
				line = br.readLine();
			}
			
			Product x = CalculatorService.max(list);
			System.out.println("Most expensive: " + x);
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	private static void generics() {
		Scanner sc = new Scanner(System.in);

		PrintServiceGeneric<String> ps = new PrintServiceGeneric<>();

		System.out.print("How many values? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String value = sc.next();
			ps.addValue(value);
		}
		ps.print();
		System.out.println("\nFirst: " + ps.first());

		sc.close();
	}
}
