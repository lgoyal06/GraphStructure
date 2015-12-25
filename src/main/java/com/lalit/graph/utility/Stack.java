package com.lalit.graph.utility;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	private List<T> list = new ArrayList<T>();

	private int top = 0;

	public T pop() {
		if (top > 0) {
			return list.remove(--top);
		}
		return null;
	}

	public T peek() {
		if (top > 0) {
			return list.get(top - 1);
		}
		return null;
	}

	public void push(T node) {
		this.list.add(node);
		++top;
	}

	public int size() {
		return list.size();
	}

	public List<T> list() {
		return list;
	}

}