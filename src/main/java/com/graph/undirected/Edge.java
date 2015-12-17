package com.graph.undirected;

class Edge {
	private String connectedNodeName;
	private String edgeName;

	public Edge(String edgeName) {
		this.edgeName = edgeName;
	}

	public String getEdgeName() {
		return edgeName;
	}

	public void setEdgeName(String edgeName) {
		this.edgeName = edgeName;
	}

	public String getConnectedNodeName() {
		return connectedNodeName;
	}

	public void setConnectedNodeName(String connectedNodeName) {
		this.connectedNodeName = connectedNodeName;
	}

}