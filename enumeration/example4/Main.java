package enumeration.example4;

public class Main {
	public enum Direction {
	    NORTH,
	    SOUTH,
	    EAST,
	    WEST
	  }

	  public static void main(String[] args) {
	    Direction direction1 = Direction.SOUTH;
	    Direction direction2 = Direction.EAST;

	    System.out.println("First direction: " + direction1);
	    System.out.println("Second direction: " + direction2);
	  }

}
