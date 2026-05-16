package model.entities;

import modal.enums.Color;

public class Rectangle extends AbstractShape{
	
	private Double width;
	private Double height;
	
	public Rectangle(Color color, Double width, Double height) {
		super(color);
		this.width = width;
		this.height = height;
	}

	@Override
	public double area() {
		return width * height;
	}
	
}
