package com.example3;
import com.example3.model.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flyable plane = new Aeroplane();
		Flyable heli = new Helicopter();
		Flyable space = new Spacecraft();
		
		plane.fly_obj();
		heli.fly_obj();
		space.fly_obj();
		
	}

}
