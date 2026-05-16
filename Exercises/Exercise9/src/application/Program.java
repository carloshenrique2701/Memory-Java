package application;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Set<Integer> alexStudents = new HashSet<>();
		
		for (int i = 0; i < 3; i++) {
			String course = i == 0 ? "A" : i == 1 ? "B" : "C";
			System.out.print("How many students for course " + course + "? ");
			int n = sc.nextInt();
			for (int j = 0; j < n; j++) {
				System.out.println("What the code of student?");				
				alexStudents.add(sc.nextInt());
			}
		}
		
		System.out.println("\nTotal students: " + alexStudents.size());

	}

}
