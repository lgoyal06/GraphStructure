package com.lalit.graph.elements;

public class Edge {
	private String connectedNodeName;
	private String edgeName;

	public Edge(String edgeName) {
		this.edgeName = edgeName;
	}

	public Edge(String edgeName, String connectedNodeName) {
		this.edgeName = edgeName;
		this.connectedNodeName = connectedNodeName;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Edge))
			return false;
		if (obj == this)
			return true;
		return this.connectedNodeName.equalsIgnoreCase(((Edge) obj).connectedNodeName);
	}

	public int hashCode() {
		return this.connectedNodeName.hashCode();
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