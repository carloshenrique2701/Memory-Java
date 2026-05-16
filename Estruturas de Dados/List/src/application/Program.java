package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String args[]) {

		List<String> list = new ArrayList<>();

		list.add("Selena");
		list.add("Aline");
		list.add("Bob");
		list.add("Dino");
		list.add(2, "Alasão");

		System.out.println(list.size());

		System.out.println("\n==========================\n");

		for (String obj : list) {

			System.out.println(obj);

		}

		System.out.println("\n==========================\n");
		//Remova com uma condição
		list.removeIf(x -> x.charAt(0) == 'A');

		for (String obj : list) {

			System.out.println(obj);

		}

		System.out.println("\n==========================\n");
		//Procura o index do elemento, -1 caso não encontrado
		System.out.println("Index of Bob: " + list.indexOf("Bob"));
		System.out.println("Index not found: " + list.indexOf("eu"));


		System.out.println("\n==========================\n");
		//Filtrar uma lista para dentro de uma segunda
		List<String> result = list.stream()
				.filter(x -> x.charAt(0) == 'S')
				.collect(Collectors.toList());
		
		for (String obj : result) {
			
			System.out.println(obj);
			
		}

		System.out.println("\n==========================\n");
		//Procurar o primeiro elemento com essa característica, caso não exista null
		String name = list.stream()
				.filter(x -> x.charAt(0) == 'D')
				.findFirst()
				.orElse(null);
		
		System.out.println(name);
		
	}

}
