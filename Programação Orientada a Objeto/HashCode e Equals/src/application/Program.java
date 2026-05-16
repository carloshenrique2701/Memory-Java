package application;

import model.entities.Client;

public class Program {
	public static void main(String[] args) {

		String a = "Maria";
		String b = "Alex";
		
		//100% de certeza
		System.out.println(a.equals(b));
		//Objetos iguais nunca terão hashCodes diferentes, e se forem iguais, 97% de certeza dos objetos serem iguais
		System.out.println(a.hashCode() == b.hashCode());
		System.out.println(b.hashCode());
		System.out.println(a.hashCode());
		
		Client c1 = new Client("Maria", "maria@gmail.com");
		Client c3 = new Client("Maria", "maria@gmail.com");
		Client c2 = new Client("Maria", "alex@gmail.com");

		System.out.println("\n=================================\n");
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());//Compara o conteúdo a partir do código
		
		System.out.println(c1.equals(c3));
		System.out.println(c1.equals(c2));//Compara o conteúdo
		
		System.out.println(c1 == c2);//Referência de memoria diferente
		System.out.println(c1 == c3);
		
		String s1 = "Test";
		String s2 = "Test";
		String s3 = new String("Test");
		String s4 = new String("Test");

		System.out.println("\n=================================\n");
		
		System.out.println(s1 == s2);//Compara o conteúdo
		System.out.println(s3 == s4);//Referência de memoria diferente
		
	}
}
