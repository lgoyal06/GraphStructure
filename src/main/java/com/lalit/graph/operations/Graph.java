package com.lalit.graph.operations;

public interface Graph {

	Object insertNode(String nodeNameId);

	boolean deleteNode(String nodeToBeDeleted);

	boolean deleteEdge(String edgeName);

	boolean updateNodeInfo(String nodeNameId, String nodeInfo);

	boolean updateEdgeInformation(String edgeName, String edgeInformation);

	boolean isDirected(String edgeName);

	boolean isUndirected(String edgeName);
}
