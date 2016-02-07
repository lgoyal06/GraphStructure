package com.lalit.graph.operations;

/**
 * @author lalit goyal
 * 
 *         This interface contains generic methods which can be used by
 * 
 *         1.Directed
 * 
 *         2.Undirected
 * 
 *         3.Hybrid Graph
 *
 */
public interface HybridGraphCRUDOperations {

	boolean insertDirectedEdge(String fromNodeName, String toNodeName, String edgeName);

	boolean insertUndirectedEdge(String fromNodeName, String toNodeName, String edgeName);

	boolean isDirectedEdge(String edgeName);

	boolean isUndirectedEdge(String edgeName);

	int numDirectedEdges();

	int numUndirectedEdges();

	boolean makeUndirected(String edgeName);

}