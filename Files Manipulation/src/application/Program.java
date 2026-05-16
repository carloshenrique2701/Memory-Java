package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a file path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		System.out.println("getName: " + path.getName());
		System.out.println("getParent: " + path.getParent());
		System.out.println("getPath: " + path.getPath());
		
		sc.close();
		
	}

	private static void listFilesAndFolders() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();

		File path = new File(strPath);
		// Function tolist just files
		File[] folders = path.listFiles(File::isDirectory);
		File[] files = path.listFiles(File::isFile);

		System.out.println("FOLDERS");
		for (File folder : folders) {
			System.out.println(folder);
		}

		System.out.println("\nFILES");
		for (File file : files) {
			System.out.println(file);
		}

		boolean sucess = new File(strPath + "/subdir").mkdir();
		System.out.println("\nSucess: " + sucess);
		sc.close();
	}

	private static void writeFile() {
		String[] lines = { "Good night!", "How are you?" };

		// True for no rewrite and false or nothing to rewrite
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Hello.txt", true))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void secondExemploOfReading() {

		try (BufferedReader br = new BufferedReader(new FileReader("file.txt"));) {

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	private static void exempleOfReading() {
		File file = new File("file.txt");
		Scanner sc = null;

		try {
			sc = new Scanner(file);

			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
