package com.lalit.graph.directed;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	private List<T> list = new ArrayList<T>();

	private int top = 0;

	public T pop() {
		if (top > 0) {
			return list.remove(--top);
		} else {
			throw null;
		}
	}

	public T peek() {
		if (top > 0) {
			return list.get(top - 1);
		} else {
			throw null;
		}
	}

	public void push(T node) {
		this.list.add(node);
		++top;
	}

	public boolean containsElement(T element) {
		return list.contains(element);
	}

	public int size() {
		return list.size();
	}

	public String toString() {
		String listElement = "";
		for (T t : list) {
			listElement = listElement + "" + t + ",";
		}
		return listElement;
	}

	public List<T> list() {
		return list;
	}

	public void clearAllElements() {
		list.clear();
		top = 0;
	}
}