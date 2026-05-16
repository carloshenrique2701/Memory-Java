package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import model.entities.Product;


//Nessa classe foram apresentados os métodos de programação funcional, predicate, consumer e function
//E, em cada um deles, foram feitos 5 exemplos até chegarmos no por quê uma função lambda (arrow function, é muito comum no JS) funciona.
public class Program {

	public static void main(String[] args) {

		function();

	}

	private static void function() {
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 3900.00));
		list.add(new Product("Tablet", 400.00));
		list.add(new Product("PS5 Pro", 5300.00));
		list.add(new Product("Dissipador de calor", 43.00));
		
		//.stream() -> converte a lista para um novo tipo de dados (como quando convertemos para um JSON ou em linguagem de máquina)
		//.map() -> somente funciona em dados do tipo stream, ele iterage sobre cada elemento da lista aplicando, nesse caso, caixa alta para o nome de todos os produtos.
		//.collext(Collectors.toList()) -> converte de volta os dados para uma lista onde podemos trabalhar com os novos dados dos nomes em caixa alta.
		//List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
		
		//List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
		//List<String> names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());
		/*
		Function<Product, String> func = p -> p.getName().toUpperCase();
		List<String> names = list.stream().map(func).collect(Collectors.toList());
		*/
		
		List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		list.forEach(System.out::println);
		System.out.println();
		names.forEach(System.out::println);
		
	}

	private static void consumer() {
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 3900.00));
		list.add(new Product("Tablet", 400.00));
		list.add(new Product("PS5 Pro", 5300.00));
		list.add(new Product("Dissipador de calor", 43.00));
		
		//list.forEach(new PriceUpdate());
		
		//list.forEach(Product::staticPriceUpdate);
		//list.forEach(Product::nonStaticPriceUpdate);
		
		/*Consumer<Product> con = p -> p.setPrice(p.getPrice() * 1.1);
		list.forEach(con);*/
		
		
		list.forEach(p -> p.setPrice(p.getPrice() * 1.1));
		
		list.forEach(System.out::println);
		
	}

	private static void predicate() {
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 3900.00));
		list.add(new Product("Tablet", 400.00));
		list.add(new Product("PS5 Pro", 5300.00));
		list.add(new Product("Dissipador de calor", 43.00));
		
		//list.removeIf(new ProductPredicate());
		
		//method reference: coloca  classe de referência onde o método está + "::" + o nome do método
		//list.removeIf(Product::staticProductPredicate);
		//list.removeIf(Product::nonStaticProductPredicate);
		
		/*Predicate<Product> pred = p -> p.getPrice() >= 500;
		list.removeIf(pred);*/
		

		//Tudo isso antes foi pra explicar como e por quê isso funciona
		list.removeIf(p -> p.getPrice() >= 100);
		
		for (Product product : list) {
			System.out.println(product);
		}

	}

	private static void programacaoFuncional() {
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 3900.00));
		list.add(new Product("Tablet", 400.00));
		list.add(new Product("PS5 Pro", 5300.00));

		// Versão mais "suja"
		/*
		 * Comparator<Product> comp = new Comparator<Product>() {
		 * 
		 * @Override public int compare(Product p1, Product p2) { return
		 * p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()); }
		 * 
		 * };
		 */

		// Versão com lambda (arrow function)
		Comparator<Product> comp = (p1, p2) -> {
			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		};

		// Mais simples
		// Comparator<Product> comp = (p1,p2) ->
		// p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

		list.sort(comp);
		// list.sort((p1,p2) ->
		// p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		// list.sort(new MyComparator());

		for (Product product : list) {
			System.out.println(product);
		}
	}

}
