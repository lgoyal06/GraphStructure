package com.lalit.graph.elements.version2;

public class Edge {

	private String toNode;
	private String edgeInformation;
	private String fromNode;
	private boolean isDirectedEdge;

	public boolean isDirectedEdge() {
		return isDirectedEdge;
	}

	public void setDirectedEdge(boolean isDirectedEdge) {
		this.isDirectedEdge = isDirectedEdge;
	}

	public String getToNode() {
		return toNode;
	}

	public void setToNode(String toNode) {
		this.toNode = toNode;
	}

	public String getFromNode() {
		return fromNode;
	}

	public void setFromNode(String fromNode) {
		this.fromNode = fromNode;
	}

	public String getEdgeInformation() {
		return edgeInformation;
	}

	public void setEdgeInformation(String edgeInformation) {
		this.edgeInformation = edgeInformation;
	}

}
