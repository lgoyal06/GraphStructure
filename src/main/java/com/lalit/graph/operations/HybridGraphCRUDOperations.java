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

	public boolean insertDirectedEdge(String fromNodeName, String toNodeName, String edgeName);

	public boolean insertUndirectedEdge(String fromNodeName, String toNodeName, String edgeName);

	public boolean isDirected(String edgeName);

	public boolean isUndirected(String edgeName);

	public int numDirectedNodes();

	public int numUndirectedNodes();

	public int numDirectedEdges();

	public int numUndirectedEdges();

}