package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Entity;
import entities.LegalEntity;
import entities.NaturalPerson;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		List<Entity> entities = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		sc.nextLine();
		for (int i = 0; i < n; i++) {

			System.out.println("\nTax payer #" + (i + 1) + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			
			if (ch == 'i') {
				
				System.out.print("Health costs: ");
				double healthCosts = sc.nextDouble();
				
				entities.add(new NaturalPerson(name, annualIncome, healthCosts));
				
			} else if (ch == 'c') {
				
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				
				entities.add(new LegalEntity(name, annualIncome, numberOfEmployees));
				
			}

		}
		
		double sum = 0;
		
		System.out.println("\nTAXES PAID: ");
		for (Entity entity : entities) {
			sum += entity.calcTaxes();
			System.out.printf(entity.getName() + " $%.2f%n", entity.calcTaxes());
		}
		
		System.out.printf("\nTOTAL TAXES: $%.2f", sum);

	}

}
