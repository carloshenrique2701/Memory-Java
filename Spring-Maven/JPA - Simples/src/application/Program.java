package application;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(1, "Carlos Henrique", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(2, "Gabriel Rodrigues", "gabriel@gmail.com");
		Pessoa p3 = new Pessoa(3, "Davi Rodrigues", "davi@gmail.com");

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
	}

}
