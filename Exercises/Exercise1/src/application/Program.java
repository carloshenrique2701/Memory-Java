package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Items;
import entities.Order;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("==||||== Enter client data: ==||||==");
		System.out.print("\nName: ");
		String name = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date birthDate;

		while (true) {
			
			System.out.print("Birth date (DD/MM/YYYY): ");
			String inputDate = sc.nextLine();
			
			try {
				birthDate = sdf.parse(inputDate);
				break;
			} catch (ParseException e) {
				System.out.println("Formato inválido! Tente novamente.");
			}
			
		}

		System.out.println("\n|||| Enter order data: ||||");		
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		

		Date date = new Date();
		
		Order o = new Order(
				date, 
				status, 
				new Client(name, email, birthDate)
				);
		
		System.out.print("How Many items to this order? ");
		int qntItems = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < qntItems; i++) {
			
			System.out.println("\nEnter #" + (i +1) + " item data: " );
			System.out.print("Product name: : ");
			String itemName = sc.nextLine();
			
			System.out.print("Product price: : ");
			double itemPrice = sc.nextDouble();

			System.out.print("Quantity: : ");
			int itemQuantity = sc.nextInt();
			sc.nextLine();
			Items item = new Items(itemName, itemQuantity, itemPrice);
			
			o.addItem(item);
		}
		
		System.out.println("\n==================ORDER SUMARY==================");
		System.out.println(o);
	}

}
