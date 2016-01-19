package com.lalit.undirected.graph.operations;

public class Edge {
	private String connectedNodeName;
	private String edgeName;

	public Edge(String edgeName, String connectedNodeName) {
		this.edgeName = edgeName;
	}

	public String getEdgeName() {
		return edgeName;
	}

	public String getConnectedNodeName() {
		return connectedNodeName;
	}

	public void setConnectedNodeName(String connectedNodeName) {
		this.connectedNodeName = connectedNodeName;
	}

}