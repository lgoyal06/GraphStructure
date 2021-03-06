package com.lalit.graph.operations;

/**
 * @author lalit goyal
 * 
 *         This interface contains common graph methods which can be used by
 * 
 *         1.Directed
 * 
 *         2.Undirected
 * 
 *         3.Hybrid Graph
 *
 */
public interface GraphCRUDOperations {

	boolean insertEdge(String fromNodeName, String toNodeName, String edgeName);

	Object insertNode(String nodeName);

	boolean deleteNode(String nodeToBeDeleted);

	boolean deleteEdge(String edgeName);

	boolean updateNodeInfo(String nodeName, String nodeInfo);

	boolean updateEdgeInformation(String edgeName, String edgeInformation);

	int numNodes();

	int numEdges();

	boolean areAdjacent(String nodeA, String nodeB);

	String opposite(String node, String edge);

	String[] endVertices(String edge);

	int degree(String nodeNameId);

	boolean isNodeExists(String node);

}