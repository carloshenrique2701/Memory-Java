package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.service.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter the contract data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate initDate = LocalDate.parse(sc.nextLine(), df);
		
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		System.out.print("Installments: ");
		int installments = sc.nextInt();
		
		Contract c = new Contract(number, initDate, totalValue, installments);
		
		System.out.println("\nINSTALLMENTS:");
		
		PaypalService pay = new PaypalService();
		
		for (int i = 1; i <= installments; i++) {
			
			System.out.println(c.getInitData().plusMonths(i).format(df) + " - R$" + String.format("%.2f", pay.calcInstallment(c.getValuePerInstallment(), i)));
			
		}

	}

}
