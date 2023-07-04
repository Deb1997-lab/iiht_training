package sync.example1.model;
import java.util.*;

public class SynchronisedStack<T> {
	private final Deque<T> stack = new ArrayDeque<>();
	
	public synchronized void push(T item) {
		stack.push(item);
	}
	
	public  Integer[] viewStack() {
		Integer[] stackArray = stack.toArray(new Integer[0]);
		return stackArray;
	}
	
	public synchronized T pop() throws EmptyStackException{
		if(stack.isEmpty()) {
			throw new EmptyStackException("Stack is empty...");
		}
		return stack.pop();
	}
}
