package application;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

import entities.People;
import entities.Product;
import entities.Rooms;

public class Program {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		pensionato();

		sc.close();

	}

	private static void pensionato() {

		System.out.print("How many rooms will be rented? ");
		int r = sc.nextInt();

		if (r > 10 || r < 0) {

			System.out.println("We have just 10 rooms.");
			return;

		}

		Rooms[] room = new Rooms[10];

		sc.nextLine();
		for (int i = 0; i < r; i++) {

			System.out.println("\nRent #" + (i + 1) + ":");

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Email: ");
			String email = sc.nextLine();

			int roomNamber = 0;
			while (true) {
				boolean rented = false;
				System.out.print("Room: ");
				roomNamber = sc.nextInt();

				for (Rooms ro : room) {

					if (ro != null && ro.getNumber() == roomNamber - 1) {
						rented = true;
						break;
					}

				}

				if (rented) {
					System.out.println("This room is rented, change the room.");
				} else {
					break;
				}

			}

			room[roomNamber - 1] = new Rooms(roomNamber - 1, name, email);
			sc.nextLine();
		}

		System.out.println("\nBusy rooms:");

		for (Rooms ro : room) {

			if (ro != null) {
				System.out.println(ro);
			}

		}

	}

	private static void ex2() {

		System.out.println("How many people will you register? ");
		int n = sc.nextInt();
		sc.nextLine();

		People[] people = new People[n];

		for (int i = 0; i < people.length; i++) {

			System.out.printf("Enter a name: ");
			String name = sc.nextLine();

			System.out.printf("Enter a age: ");
			int age = sc.nextInt();

			System.out.printf("Enter a height: ");
			double height = sc.nextDouble();
			sc.nextLine();

			people[i] = new People(name, age, height);
			System.out.println("Person registered!");
		}

		double sumHeight = 0;
		int countMinors = 0;

		for (People p : people) {

			sumHeight += p.getHeight();
			if (p.getAge() < 16) {
				countMinors++;
			}

		}

		double avgHeight = sumHeight / n;
		double percentMinors = ((double) countMinors / n) * 100.0;

		System.out.printf("%nAVERAGE HEIGHT: %.2f%n", avgHeight);
		System.out.printf("PEOPLE UNDER 16: %.1f%%%n", percentMinors);

		for (People p : people) {
			if (p.getAge() < 16) {
				System.out.println(p.getName());
			}
		}
	}

	private static void ex1() {

		System.out.println("How many numbers will you enter? ");
		int n = sc.nextInt();

		int[] vector = new int[n];

		for (int i = 0; i < vector.length; i++) {

			System.out.println("Enter a number: ");
			vector[i] = sc.nextInt();

		}

		System.out.println("\nNEGATIVE NUMBERS\n");
		for (int v : vector) {

			if (v < 0) {

				System.out.println(v);

			}

		}

	}

	public static void exemplo() {
		System.out.println("Enter the vector length: ");
		int n = sc.nextInt();
		Product[] vect = new Product[n];

		for (int i = 0; i < vect.length; i++) {
			sc.nextLine();
			System.out.println("Enter a name of the product: ");
			String name = sc.nextLine();
			System.out.println("Enter a price of the product: ");
			double price = sc.nextDouble();
			vect[i] = new Product(name, price);

		}

		double sum = 0;
		for (int i = 0; i < vect.length; i++) {
			sum += vect[i].getPrice();
		}

		double avg = sum / vect.length;

		System.out.printf("PRICE AVERAGE: %.2f", avg);
	}

}
