package com.lalit.undirected.Graph.operations;

public interface UndirectedGraphCRUDOperations {

	boolean insertUndirectedEdge(String nodeAName, String nodeBName, String edgeName);

	int degree(String nodeNameId);

}