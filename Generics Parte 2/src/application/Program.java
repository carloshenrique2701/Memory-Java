package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.entities.Circle;
import model.entities.Rectangle;
import model.interfaces.Shape;

public class Program {

	public static void main(String[] args) {
		
		exemple2();

	}
	
	private static void exemple2() {
		//Covariânça
		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(5);
		//Qualquer subtipo do tipo Number
		List<? extends Number> list = intList;
		//É possível resgatar mas não é possível adicionar
		Number x = list.get(0);
		//list.add(20);
		
		
		//Contravariância
		List<Object> myObjs = new ArrayList<Object>();
		myObjs.add("Maria");
		myObjs.add("Alex");
		
		List<? super Number> myNums = myObjs;
		myNums.add(10);
		myNums.add(2.14);
		//Aqui acontece justamente o contrário, é possível adicionar mas não é possível resgatar.
		//Number x = myNums.get(0);
		
		
		List<Integer> myInts = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Object> myObjs2 = new ArrayList<>();
		
		copy(myInts, myObjs2);
		printList(myObjs2);
		copy(myDoubles, myObjs2);
		printList(myObjs2);
		
	}

	//A lista original não pode adicionar e pode resgatar, enquanto que a lista de destino pode adicionar e não pode resgatar
	private static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for (Number number : source) {
			destiny.add(number);
		}
	}
	
	//Printa qualquer lista (não pode adicionar elementos a ela)
	private static void printList(List<?> list) {
		System.out.println();
		for (Object object : list) {
			System.out.print(object + " ");
		}
	}

	private static void exemple1() {
		List<Shape> myShapes = new ArrayList<>();
		myShapes.add(new Rectangle(3.0, 2.0));
		myShapes.add(new Circle(2.0));
		
		List<Circle> myCircles = new ArrayList<>();
		myCircles.add(new Circle(2.0));
		myCircles.add(new Circle(4.0));
		
		
		System.out.println("Total area: " + totalArea(myCircles));
	}

	//Essa lista pode ser um tipo Shape ou qualquer subtipo do mesmo
	private static double totalArea(List<? extends Shape> list) {
		
		double sum = 0;
		for (Shape s : list) {
			sum += s.area();
		}
		return sum;
		
	}

}
