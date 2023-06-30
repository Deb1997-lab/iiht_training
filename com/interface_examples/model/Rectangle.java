package com.interface_examples.model;

public class Rectangle implements Shape {
	private double length;
	private double width;
	private double height;
	

	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	public Rectangle(double length, double width, double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		
		return length*width;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return length*width*height;
	}

}
