package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TreeSet;

import model.entities.User;

public class Program {
	public static void main(String[] args) {
		
		Set<User> users = new TreeSet<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))){
			String lineStr;
			
			while ((lineStr = br.readLine()) != null) {
				
				String[] line = lineStr.split(" ");
				String name = line[0];
				Instant formattedDate = Instant.parse(line[1]);
				
				User newUser = new User(name, formattedDate);
				
				if (!users.add(newUser)) {
			        for (User u : users) {
			            if (u.equals(newUser)) {
			                u.addAccsDate(formattedDate);
			                break;
			            }
			        }
			    }
				
			}
			System.out.println("Users: " + users.size());
			for (User u : users) {
				System.out.println("\n" + u);
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}
