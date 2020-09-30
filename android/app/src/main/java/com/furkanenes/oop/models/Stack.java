package com.furkanenes.oop.models;

public class Stack {
	
	private Object[] stack;
	private int top;
	
	public Stack(int capacity) {
		this.stack = new Object[capacity];
		this.top = 0;
	}
	
	public void Push(Object o) {
		if (top == stack.length) {
			System.out.println("Stack overflow!!!");
		}
		else {
			stack[top] = o;
			top++;
		}
	}
	
	public Object Pop() {
		Object temp = null;
		if (top == 0) {
			System.out.println("Stack is empty");
			return temp;
		}
		else {
			temp = stack[top-1];
			top--;
			return temp;
		}
	}
	
	public Object Peek() {
		if (top == 0) {
			System.out.println("Stack is empty");
			return null;
		}
		else {
			return stack[top-1];
		}
	}
	
	public boolean isEmpty() {
		if (top == 0) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	public boolean isFull() {
		if (top == 0) {
			return false;
		} 
		else {
			return true;
		}
	}
	
	public int Size() {
		return top;
	}
}