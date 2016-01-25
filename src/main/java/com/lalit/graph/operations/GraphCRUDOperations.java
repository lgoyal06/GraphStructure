package com.lalit.graph.operations;

public interface GraphCRUDOperations {

	boolean insert(String fromNodeName, String toNodeName, String edgeName);

	boolean deleteNode(String nodeToBeDeleted);

	boolean deleteEdge(String edgeName);

	boolean updateNodeInfo();

	boolean updateEdgeInfo();

	Object insertNode(String fromNodeName);

	boolean insertDirectedEdge(String fromNodeName, String toNodeName, String edgeName);

	boolean insertUndirectedEdge(String nodeA, String nodeB, String edgeName);
}