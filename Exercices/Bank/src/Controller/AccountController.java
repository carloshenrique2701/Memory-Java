package Controller;

import java.util.Locale;
import java.util.Scanner;
import Entity.Account;

public class AccountController {

	static Scanner sc = new Scanner(System.in);
	private static Account account;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		newAccount();
		showMenu();

	}

	private static void newAccount() {

		System.out.println("Enter account number: ");
		int accountNumber = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter account holder: ");
		String accountName = sc.nextLine();

		System.out.println("Is there a initial deposit (s/n)?");
		String isThereDeposit = sc.nextLine();

		if (isThereDeposit.equals("s")) {

			System.out.println("Enter initial deposit value: ");
			double initialDeposit = sc.nextDouble();

			account = new Account(accountNumber, accountName, initialDeposit);

		} else {

			account = new Account(accountNumber, accountName);

		}

		System.out.println(account);

	}

	public static void showMenu() {

		System.out.println("=======MENU=======\n" + "1. Change name;\n" + "2. Deposit;\n" + "3. Withdraw;\n"
				+ "4. Show Infos;\n" + "5. Quit;\n" + "Select the option: ");
		int option = sc.nextInt();

		switch (option) {
		case 1: {

			changeName();
			break;
		}
		case 2: {

			deposit();
			break;
		}
		case 3: {
			withdraw();
			break;
		}
		case 4: {
			System.out.println(account);
			showMenu();
			break;
		}
		case 5: {
			System.out.println("Saindo...");
			sc.close();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}

	}

	private static void withdraw() {

		System.out.println("Enter a withdraw value");
		double withdrawValue = sc.nextDouble();

		account.newWithdraw(withdrawValue);
		System.out.println("Updated Account Data: \n" + account);
		showMenu();

	}

	private static void deposit() {

		System.out.println("Enter a deposit value: ");
		double depositValue = sc.nextDouble();

		account.newDeposit(depositValue);
		System.out.println("Updated Account Data: \n" + account);
		showMenu();

	}

	private static void changeName() {
		sc.nextLine();
		System.out.println("Enter the new name: ");
		String newName = sc.nextLine();

		account.setName(newName);
		System.out.println(account);
		showMenu();

	}

}
