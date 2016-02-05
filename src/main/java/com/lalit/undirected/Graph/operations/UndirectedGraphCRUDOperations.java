package com.lalit.undirected.Graph.operations;

public interface UndirectedGraphCRUDOperations {

	/**
	 * @param nodeAName
	 * @param nodeBName
	 * @param edgeName
	 * @return
	 */
	boolean insertEdge(String nodeAName, String nodeBName, String edgeName);

}