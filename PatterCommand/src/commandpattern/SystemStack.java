package commandpattern;

import java.util.Stack;

public class SystemStack<T> {
	
	private Stack<T> stack;
	
	public SystemStack() {
		stack = new Stack();
	}
	
	void stack_pop() {
		stack.pop();
	}
	
	void stack_push(T anzahl) {
		stack.push(anzahl);
		System.out.println(anzahl);
	}
	
	T stack_peek() {
		System.out.println(stack.peek());
		return (T) stack.peek();
	}
	
	T stack_search(int element) {
		int pos = stack.search(element);
		if(pos == -1) {
			System.out.println("Element konnte nicht gefunden werden!!!");
			return null;
		} else {
			System.out.println(stack.peek());
			return stack.get(pos);
		}
	}
}