import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MyQueue<T>{
	private Stack<T> newStack;
	private Stack<T> oldStack;
	
	public MyQueue() {
		newStack=new Stack<>();
		oldStack=new Stack<>();
	}

	public void enqueue(T next) {
		if(newStack.isEmpty()) {
			newStack.push(next);
			return;
		}
		oldStack.push(next);
		
	}

	public T dequeue() {
		if(newStack.isEmpty())return null;
		T val=newStack.pop();
		if(newStack.isEmpty()) {
			while(!oldStack.isEmpty()) {
				newStack.push(oldStack.pop());
			}
		}
		return val;
	}

	public T peek() {
		return newStack.peek();
	}
	
}

public class Queue_ATableOfTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
