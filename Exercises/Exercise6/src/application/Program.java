package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String args[]) {

		boolean sucess = new File("out").mkdir();
		System.out.println("Folder created? " + sucess);
		String targetFile = "out/summary.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader("summary.csv")); 
			BufferedWriter bw2 = new BufferedWriter(new FileWriter(targetFile))) {
			
			String line = br.readLine();
			
			while (line != null) {
				
				String[] item =line.split(",");
				
				double i1 = Double.parseDouble(item[1]);
				double i2 = Double.parseDouble(item[2]);
				double total = i1 * i2;
				
				
				String totalPrice = String.format("%.2f", total);
				bw2.write(item[0] + ", " + totalPrice);
				bw2.newLine();
				
				line = br.readLine();
			}
			
			
		} catch (IOException e) {
			System.out.println("Error!");
		}
		
		
		
	}
}
