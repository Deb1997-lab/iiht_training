package com.interface_examples.model;

public class Circle implements Shape {
	private double radius;
	private static final double pi = Math.PI;
	
	
	
	
	public Circle(double radius) {
		this.radius = radius;
	}



	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return pi*Math.pow(radius, 2);
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return (4.0/3.0)*pi*Math.pow(radius, 3);
	}

}
