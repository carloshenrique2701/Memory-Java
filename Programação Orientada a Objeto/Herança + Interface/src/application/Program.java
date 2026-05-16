package application;

import java.util.Locale;

import modal.enums.Color;
import model.entities.AbstractShape;
import model.entities.Circle;
import model.entities.Rectangle;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		AbstractShape s1 = new Circle(Color.BLACK, 2.0);
		AbstractShape s2 = new Rectangle(Color.WHITE, 3.0, 4.0);
		
		System.out.println("Cicle color: " + s1.getColor());
		System.out.println("Cicle area: " + String.format("%.3f", s1.area()));

		System.out.println("Rectangle color: " + s2.getColor());
		System.out.println("Rectangle area: " + String.format("%.3f", s2.area()));
		
	}

}
