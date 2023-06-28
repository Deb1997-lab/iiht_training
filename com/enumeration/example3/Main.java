package enumeration.example3;

public class Main {
	public static void main(String[] args) {
        Shape shape = Shape.CIRCLE;

        switch (shape) {
            case CIRCLE:
                System.out.println("Selected shape: Circle");
                break;
            case SQUARE:
                System.out.println("Selected shape: Square");
                break;
            case STAR:
                System.out.println("Selected shape: Triangle");
                break;
            case RECTANGLE:
                System.out.println("Selected shape: Rectangle");
                break;
            default:
                System.out.println("Invalid shape selected");
                break;
        }
    }
}


