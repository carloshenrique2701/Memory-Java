package model.service;

import java.util.ArrayList;
import java.util.List;
//A utilização do Object pode não ser a ideal, pois ela aceita qualquer valor
//Seja int, String, não importa(Type safety). Além de ter um problema de performace,
//nos forçando a utilizar casting (Integer)(String) para armazenar seus valores
//em outras variaveis.
public class PrintServiceObject {

	private List<Object> list = new ArrayList<>();
	
	public Object first() {
		if(list.isEmpty()) {
			throw new IllegalStateException();
		}
		return list.get(0);
	}
	
	public void addValue(Object value) {
		list.add(value);
	}
	
	public void print() {
		System.out.print("[ ");
		if(!list.isEmpty()) {
			System.out.print(list.get(0));
		}
		for (int i = 1; i < list.size(); i++) {
			System.out.print(", " + list.get(i));
		}
		System.out.println(" ]");
	}
	
}
