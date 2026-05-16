package application;

import java.util.ArrayList;
import java.util.List;

import model.entities.Product;
import model.service.ProductService;

public class Program {
	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 1300.00));
		list.add(new Product("Notebook", 3300.00));
		list.add(new Product("Tablet", 400.00));
		list.add(new Product("PS5 Pro", 5300.00));
		list.add(new Product("Dissipador de calor", 43.00));
		
		ProductService ps = new ProductService();
		
		//double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');
		double sum = ps.filteredSum(list, p -> p.getPrice() > 500.00);
		
		System.out.println("Sum: " + String.format("%.2f", sum));
		
	}
}
