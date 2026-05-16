package model.entities;

public class Product {

	private String name;
	private Double price;

	public Product(String nome, Double price) {
		this.name = nome;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	//Predicate
	public static boolean staticProductPredicate(Product p) {
		return p.getPrice() >= 500.0;
	}
	//Diferentemente do outro método, esse nonSatitc ele trabalha com o objeto atual, então não precisa de receber argumentos
	public boolean nonStaticProductPredicate() {
		return getPrice() >= 500.0;
	}
	
	//Consumer
	public static void staticPriceUpdate(Product p) {
		p.setPrice(p.getPrice() * (1 + 0.1));
	}
	public void nonStaticPriceUpdate() {
		 setPrice(getPrice() * (1 + 0.1));
	}
	
	//Function
	public static String staticUpperCaseName(Product p) {
		return p.getName().toUpperCase();
	}
	public String nonStaticUpperCaseName() {
		 return getName().toUpperCase();
	}
	
	@Override
	public String toString() {
		return "Product { name: " + name + ", price: " + String.format("%.2f", price) + " }";
	}

}
