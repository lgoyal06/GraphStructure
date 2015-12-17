package com.graph.undirected;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

	List<T> edgeList;

	public List<T> getEdgeList() {
		if (edgeList == null) {
			return new ArrayList<T>();
		} else {
			return edgeList;
		}
	}

	public void setEdgeList(List<T> edgeList) {
		this.edgeList = edgeList;
	}
}