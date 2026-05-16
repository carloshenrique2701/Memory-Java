package application;

import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
	public static void main(String args[]) {

		List<Account> list = new ArrayList<>();
		
		//Uma classe abstrata não pode ser instanciada
		//Account acc1 = new Account(1001, "Alex", 1000.0);
		list.add(new SavingsAccount(1001, "Lucia", 1000.0, 0.01));
		list.add(new SavingsAccount(1002, "Maria", 1000.0, 0.01));
		list.add(new BusinessAccount(1003, "Bob", 1000.0, 500.0));
		list.add(new BusinessAccount(1004, "Alex", 1000.0, 500.0));
		
		double sum = 0.0;
		
		for (Account acc : list) {
			sum += acc.getBalance();
		}
		
		System.out.printf("Total balance: %.2f%n", sum);
		
		for (Account acc: list) {
			acc.deposit(10.0);
		}
		
		for (Account acc : list) {
			System.out.printf("Updated balance for account %d: %.2f%n", acc.getNamber(), acc.getBalance());
		}

	}
/*
	private static void exercise() {
		Locale.setDefault(Locale.US);

		Account acc1 = new Account(1001, "Alex", 1000.0);
		acc1.withdraw(200.0);
		System.out.println(acc1.getBalance());

		Account acc2 = new SavingsAccount(1004, "Anna", 1000.0, 0.01);
		acc2.withdraw(200.0);
		System.out.println(acc2.getBalance());

		Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
		acc3.withdraw(200.0);
		System.out.println(acc3.getBalance());
	}

	private static void upAndDownCasting() {
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

		// UPCASTING

		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

		// DOWNCASTING

		BusinessAccount acc4 = (BusinessAccount) acc2;
		acc4.loan(100.0);

		// Um Objeto do tipo BusinessAccount não pode ser convertido para SavingsAccount
		// Lembrando que o compilador não consegue identificar isso;
		// BusinessAccount acc5 = (BusinessAccount) acc3;

		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount) acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}

	}*/
}
