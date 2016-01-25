package com.lalit.graph.operations;

public interface GraphCRUDOperations {

	boolean insertOperation(String fromNodeName, String toNodeName, String edgeName);

	boolean deleteNodeOperation(String nodeToBeDeleted);

	boolean deleteEdgeOperation(String edgeName);

	boolean updateNodeInfo();

	boolean updateEdgeInfo();

	Object insertNodeOperation(String fromNodeName);

	boolean insertDirectedEdgeOperation(String fromNodeName, String toNodeName, String edgeName);

	boolean insertUndirectedEdgeOperation(String nodeA, String nodeB, String edgeName);
}