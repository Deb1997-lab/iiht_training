package com.interface_examples.model;

public class Triangle implements Shape {
	
	private double base;
	private double height;
	private static final double pi = Math.PI; 

	public Triangle() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}



	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0.5*base*height;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return (2.0/3.0)*pi*Math.pow(base, 2)*height;
	}

}
