package model.utils;

import java.util.Comparator;

import model.entities.Product;

//Interface funcional (Uma interface que tem somente um método abstrato)
public class MyComparator implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		//return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		return -p1.getPrice().compareTo(p2.getPrice());
	}
	

}
