import java.util.*;
public class MinStack {
	private LinkedList<Integer> stack=new LinkedList<>();
	private LinkedList<Integer> minStack=new LinkedList<>();
	
	public MinStack() {

	}

	public void push(int x) {
		stack.add(x);
		
		if(minStack.size()<1)minStack.add(x);
		else minStack.add(minStack.peekLast()<x?minStack.peekLast():x);
	}

	public void pop() {
		stack.removeLast();
		minStack.removeLast();
		
	}

	public int top() {
		if(stack.size()<1) return 0;
		return stack.getLast();
	}

	public int getMin() {
		return minStack.getLast();
	}
}
