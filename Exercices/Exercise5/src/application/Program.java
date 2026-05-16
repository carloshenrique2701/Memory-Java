package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.NewAccountException;

public class Program {
	public static void main(String[] main) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("****Enter account data****");
			System.out.print("Number: ");
			int number = sc.nextInt();
			
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			
			System.out.print("Withdraw Limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account a1 = new Account(number, holder, balance, withdrawLimit);
			
			System.out.print("\nEnter amount for withdraw: ");
			double amount = sc.nextDouble();
			
			a1.withdraw(amount);
			
			System.out.printf("Balance: %.2f", a1.getBalance());
			
		} catch (NewAccountException e) {
			System.out.println("\nWithdraw Error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("\nInput value inválid!");
		}
		
	}
}
