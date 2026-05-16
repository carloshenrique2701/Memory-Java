package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.ImportedProduct;
import entities.OutsourcedEmployee;
import entities.Product;
import entities.UsedProduct;

public class Program {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		sc.useLocale(Locale.US);
		
		List<Product> products = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			System.out.println("\nProduct #" + (i + 1) + " data: ");
			System.out.print("Commen, Used or Imported (c/u/i)? ");
			char s = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("Name: ");
			String productName = sc.nextLine();
			
			System.out.print("Price: ");
			double productPrice = sc.nextDouble();
			
			if (s == 'i') {
				System.out.print("Customs fee: ");
				double productCostumsFee = sc.nextDouble();
				
				products.add(new ImportedProduct(productName, productPrice, productCostumsFee));
				
			} else if (s == 'u') {

				sc.nextLine();
				
				while (true) {
					
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					String inputDate = sc.nextLine();
					
					try {
						Date manufatureDate = sdf.parse(inputDate);
						products.add(new UsedProduct(productName, productPrice, manufatureDate));
						break;
					} catch (ParseException e) {
						System.out.println("Inválid format!");
					}
					
				}
			} else if (s == 'c') {
				products.add(new Product(productName, productPrice));
			} 
			
			
		}
		
		System.out.println("\nPRICE TAGS: ");
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		
	}

	private static void employeeExemple() {
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			
			System.out.println("\nEmployee #" + i + " data: ");
			System.out.print("Outsourced (y/n)? ");
			char ch = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			

			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			if ( ch == 'y') {
				
				System.out.print("Aditional charge: ");
				double additionalCharge = sc.nextDouble();
				
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
				
			} else {
				list.add( new Employee(name, hours, valuePerHour));
			}
			
		}
		
		System.out.println("\nPAYMENTS: ");
		for (Employee e : list) {
			
			System.out.println("\n" + e.getName() + " - $" + String.format("%.2f", e.payment()));
			
		}
		
	}

}
