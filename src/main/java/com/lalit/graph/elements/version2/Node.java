package com.lalit.graph.elements.version2;

import java.util.List;

public class Node {

	private String nodeName;
	private List<String> incomingEdgeList;
	private List<String> outGoingEdgeList;

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public List<String> getIncomingEdgeList() {
		return incomingEdgeList;
	}

	public void setIncomingEdgeList(List<String> incomingEdgeList) {
		this.incomingEdgeList = incomingEdgeList;
	}

	public List<String> getOutGoingEdgeList() {
		return outGoingEdgeList;
	}

	public void setOutGoingEdgeList(List<String> outGoingEdgeList) {
		this.outGoingEdgeList = outGoingEdgeList;
	}
}
