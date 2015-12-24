package com.lalit.graph.directed;

import java.util.ArrayList;
import java.util.List;

public class Node {

	public List<Edge> edgeList;

	public List<Edge> getEdgeList() {
		if (edgeList == null) {
			return new ArrayList<Edge>();
		} else {
			return edgeList;
		}
	}

	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}
}