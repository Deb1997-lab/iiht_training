package sync.example1;
import sync.example1.model.*;

public class Main {
	public static void main(String[] args) {
		SynchronisedStack<Integer> sync_stack = new SynchronisedStack<>();
		try {
			for (int i=0;i<10;i++) {
				sync_stack.push(i);
			}
			
			for (Integer e:sync_stack.viewStack()) {
				System.out.println(e);
			}
			
			for (int j=0;j<11;j++) {
				System.out.println(sync_stack.pop());
			}
		}catch (EmptyStackException e) {
			System.out.println("Error message: "+e.getMessage());
			
		}
	}
}
