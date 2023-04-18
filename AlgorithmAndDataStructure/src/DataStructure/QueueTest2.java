package DataStructure;

import java.util.Stack;

class MyQueue<T> {
	Stack<T> stackNewest, stackOldest;
	
	MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}
	
	public void add(T value) {
		stackNewest.push(value);
	}
	
	private void shiftStacks() {
		if(stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}
	
	public T remove() {
		shiftStacks();
		return stackOldest.pop();
	}
}

public class QueueTest2 {
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
	}
}