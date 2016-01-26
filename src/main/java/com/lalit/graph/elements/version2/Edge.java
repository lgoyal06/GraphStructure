package com.lalit.graph.elements.version2;

public class Edge {

	private String fromNode;
	private String toNode;
	private String edgeInformation;
	private boolean isDirectedEdge;

	public Edge(String edgeInformation) {
		this.edgeInformation = edgeInformation;
	}

	public boolean equals(Object obj) {
		return this.getEdgeInformation().equalsIgnoreCase(((Edge) obj).getEdgeInformation());
	}

	public int hashcode() {
		return this.getEdgeInformation().hashCode();
	}

	public String getFromNode() {
		return fromNode;
	}

	public void setFromNode(String fromNode) {
		this.fromNode = fromNode;
	}

	public String getToNode() {
		return toNode;
	}

	public void setToNode(String toNode) {
		this.toNode = toNode;
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