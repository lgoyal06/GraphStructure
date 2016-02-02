package com.lalit.directed.graph.operations;

public interface DirectedGraphCRUDOperations {

	boolean insertDirectedEdge(String fromNodeName, String toNodeName, String edgeName);

	boolean makeUndirected(String edgeName);

	boolean reverseDirection(String edgeName);

	boolean setDirectionFrom(String edgeName, String newFromNodeName);

	boolean setDirectionTo(String edgeName, String newToNodeName);

	String destination(String edgeName);

	String origin(String edgeName);

	int inDegree(String nodeName);

	int outDegree(String nodeName);

}