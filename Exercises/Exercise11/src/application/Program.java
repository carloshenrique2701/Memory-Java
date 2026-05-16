package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		List<Product> products = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String strLine;
			
			while ((strLine = br.readLine()) != null) {
				
				String[] line = strLine.split(",");
				
				products.add(new Product(line[0], Double.parseDouble(line[1])));
				
			}
			
			double avg = products.stream()
					.map(Product::getPrice)
					.reduce(0.0, (x,y) -> x + y) / products.size();
			
			System.out.println("Average Price: " + String.format("%.2f", avg));
			
			List<String> productNames = products.stream()
					.filter(x -> x.getPrice() < avg)
					.map(Product::getName)
					.sorted((s1, s2) -> -s1.toUpperCase().compareTo(s2.toUpperCase()))
					.collect(Collectors.toList());
			
			productNames.forEach(System.out::println);
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
