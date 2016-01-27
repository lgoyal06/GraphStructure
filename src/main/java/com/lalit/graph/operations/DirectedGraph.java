package com.lalit.graph.operations;

public interface DirectedGraph {

	Object insertNode(String fromNodeName);

	boolean insertDirectedEdge(String fromNodeName, String toNodeName, String edgeName);

	boolean insertUndirectedEdge(String nodeA, String nodeB, String edgeName);

	boolean deleteNode(String nodeToBeDeleted);

	boolean deleteEdge(String edgeName);

	boolean updateNodeInfo(String nodeNameId, String nodeInfo);

	boolean makeUndirected(String edgeName);

	boolean reverseDirection(String edgeName);

	boolean setDirectionFrom(String edgeName, String newFromNodeName);

	boolean setDirectionTo(String edgeName, String newToNodeName);

	boolean updateEdgeInformation(String edgeName, String edgeInformation);

}
