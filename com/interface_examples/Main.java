package com.interface_examples;
import com.interface_examples.model.*;

public class Main {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(5, 7,0);
		Rectangle cuboid = new Rectangle(6,8,9);
        Circle circle = new Circle(3);
        Triangle triangle = new Triangle(4, 6);
       

     
        System.out.println("Area of rectangle: " + rectangle.getArea());
        System.out.println("Volume of cuboid: " + cuboid.getVolume());
        
        System.out.println("Area of circle: " + circle.getArea());
        System.out.println("Volume of sphere of same radius: " + circle.getVolume());

        System.out.println("Area of triangle: " + triangle.getArea());
        System.out.println("Volume of cone of same dimensions: " + triangle.getVolume());

	}

}
