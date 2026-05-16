package application;

import java.util.Arrays;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size of the bi-dimensional matrix: ");
		int n = sc.nextInt();
		int[][] mat = new int[n][n];
		
        int count = 1; 
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print("\nPosition [" + i + "][" + j + "] - Number " + count + ": ");
                mat[i][j] = sc.nextInt();
                count++;
            }
        }
        
        System.out.println("\n--- Matrix Diagonal ---");
        for (int i = 0; i < mat.length; i++) {
        	System.out.print(mat[i][i] + " ");
        }

        System.out.println("\n\n--- Matrix Negative Numbers ---");
        int negativeCount = 0;
        for (int i = 0; i < mat.length; i++) {
        	for (int j = 0; j < mat[i].length; j++) {
        		if (mat[i][j] < 0) {
        			negativeCount++;
        			System.out.println(mat[i][j]);
        		}
        	}
        }
        System.out.println("Total of negative numbers: " + negativeCount);
        
        
        System.out.println("\n--- Matrix Result ---");
        // Forma rápida de imprimir matrizes bidimensionais:
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
		
		sc.close();

	}

}
