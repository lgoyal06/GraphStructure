package com.lalit.graph.operations;

public interface GraphCRUDOperations {

	Object insertNode(String nodeName);

	boolean insertEdge(String nodeAName, String nodeBName, String edgeName);

	boolean deleteNode(String nodeToBeDeleted);

	boolean deleteEdge(String edgeName);

	boolean updateNodeInfo(String nodeName, String nodeInfo);

	boolean updateEdgeInformation(String edgeName, String edgeInformation);

	boolean isDirected(String edgeName);

	boolean isUndirected(String edgeName);

	int numNodes();

	int numEdges();

	int degree(String nodeNameId);

	boolean areAdjacent(String nodeA, String nodeB);

	String opposite(String node, String edge);

	String[] endVertices(String edge);

}