package com.lalit.graph.elements.version2;

public class Edge {

	private String nodeA;
	private String nodeB;
	private String edgeInformation;
	private boolean isDirectedEdge;

	public String getNodeA() {
		return nodeA;
	}

	public void setNodeA(String nodeA) {
		this.nodeA = nodeA;
	}

	public String getNodeB() {
		return nodeB;
	}

	public void setNodeB(String nodeB) {
		this.nodeB = nodeB;
	}

	public boolean isDirectedEdge() {
		return isDirectedEdge;
	}

	public void setDirectedEdge(boolean isDirectedEdge) {
		this.isDirectedEdge = isDirectedEdge;
	}

	public String getEdgeInformation() {
		return edgeInformation;
	}

	public void setEdgeInformation(String edgeInformation) {
		this.edgeInformation = edgeInformation;
	}

}