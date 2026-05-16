package application;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import model.entities.Product;

public class Program {
	public static void main(String[] args) {

		exemple2();
		
	}

	private static void exemple2() {
		Map<Product, Double> stock = new HashMap<>();

		Product p1 = new Product("TV", 900.0);
		Product p2 = new Product("Notebook", 3900.0);
		Product p3 = new Product("Tablet", 400.0);

		stock.put(p1, 10000.0);
		stock.put(p2, 20000.0);
		stock.put(p3, 15000.0);

		Product ps = new Product("TV", 900.0);

		//Referencia um objeto se não houver equals/hashcode na classe 'Product' tendo resultado como false
		System.out.println("Contains 'ps' key: " + stock.containsKey(ps));

	}

	private static void exemple1() {
		Map<String, String> cookies = new TreeMap<>();

		cookies.put("UserName", "Maria");
		cookies.put("Email", "maria@gmail.com");
		cookies.put("Phone", "61992392357");

		cookies.remove("Email");
		cookies.put("Phone", "61992245496");

		System.out.println(cookies);

		System.out.println("\nContains 'Phone' key? " + cookies.containsKey("Phone"));
		System.out.println("Contains 'Email' key? " + cookies.containsKey("Email"));

		System.out.println("\nALL COOKIES");
		for (String key : cookies.keySet()) {
			System.out.println(key + ": " + cookies.get(key));
		}
	}
}
