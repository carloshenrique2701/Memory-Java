package application;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Exercice {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("Enter 2 nambers: ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int[][] mat = new int[x][y];
				
		for (int i = 0; i < mat.length; i++) {
			System.out.println("\nEnter 3 numbers: ");
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = sc.nextInt();
			}
			
		}
		
		System.out.println("\nChoose a number to know the statistics: ");
		
		for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
		
		System.out.println();
		int n = sc.nextInt();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == n) {
					System.out.println("Position: " + i + ", " + j);
					if (j - 1 >= 0) {
						System.out.println("Left: " + mat[i][j - 1]);
					}
					if (j + 1 <= mat[i].length - 1) {
						System.out.println("Right: " + mat[i][j + 1]);
					}
					if (i - 1 >= 0) {
						System.out.println("Up: " + mat[i - 1][j]);
					}
					if (i + 1 <= mat.length - 1) {
						System.out.println("Down: " + mat[i + 1][j] + "\n");
					}
				}
			}
		}
		
	}

}
