package application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import model.entities.Product;

public class Program {
	public static void main(String[] args) {

		exemple3();
		
	}

	private static void exemple3() {
		
		Set<Product> set = new TreeSet<>();
		
		set.add(new Product("TV", 900.0));
		set.add(new Product("Notebook", 1900.0));
		set.add(new Product("Tablet", 400.0));
		set.add(new Product("PS5 Slim", 3900.0));
		
		Product prod = new Product("Notebook", 1900.0);

		//Sempre retornará "false" se não tiver o hashcode/equals na classe pai
		System.out.println(set.contains(prod));
		
		for (Product p : set) {
			System.out.println("\n" + p);
		}
		
	}

	private static void exemple2() {
		Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,3,4,5,6,7,8,9,10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(11, 22, 33, 44, 55, 3, 4, 5, 6));
		
		//Union (elementos repetidos não são colocados)
		Set<Integer> c = new TreeSet<>(a);
		c.addAll(b);
		System.out.println(c);
		System.out.println();
		
		//Intesection
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.println(d);
		System.out.println();
		
		//diference
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.println(e);
	}

	private static void exemple1() {
		// HashSet -> é usado quando não precisa ter ordenação. Ele é mais rápido
		// TreeSet -> Contém ordenação. Mais Lento. (Caso seja um obj a classe do objeto, obrigatóriamente, precisa ter aimplementação Comparable)
		// LinkedHashSet -> mantém a ordem que os elementos foram inseridos. Velocidade mediana
		Set<String> set = new LinkedHashSet<>();

		set.add("Tablet");
		set.add("TV");
		set.add("Notebook");

		for (String p : set) {
			System.out.println(p);
		}

		set.remove("TV");
		System.out.println();
		for (String p : set) {
			System.out.println(p);
		}

		set.removeIf(x -> x.charAt(0) == 'T');

		System.out.println();
		for (String p : set) {
			System.out.println(p);
		}
	}
}
