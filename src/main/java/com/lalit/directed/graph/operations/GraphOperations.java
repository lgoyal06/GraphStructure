package com.lalit.directed.graph.operations;

public interface GraphOperations {

	boolean insertOperation(String fromNodeName, String toNodeName, String edgeName);

	boolean deleteNodeOperation(String nodeToBeDeleted);

	boolean deleteEdgeOperation(String toNodeName, String edgeName);

	boolean updateNodeInfo();

	boolean updateEdgeInfo();
}