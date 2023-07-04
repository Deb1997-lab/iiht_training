package sync.example1;
import sync.example1.model.*;

public class Main {
	public static void main(String[] args) {
		SynchronisedStack<Integer> sync_stack = new SynchronisedStack<>();
	
	Thread pushThread = new Thread(() -> {
        for (int i = 1; i <= 10; i++) {
            sync_stack.push(i);
            try {
                Thread.sleep(100);  // Sleep for 500 milliseconds between push operations
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    Thread popThread = new Thread(() -> {
        for (int i = 1; i <= 12; i++) {
            try {
                int value = sync_stack.pop();
                System.out.println("Popped: " + value);
                Thread.sleep(1000);  // Sleep for 1000 milliseconds between pop operations
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (EmptyStackException er) {
				// TODO Auto-generated catch block
				System.out.println(er.getMessage());
			}
        }
    });

    pushThread.start();
    popThread.start();

}
}
