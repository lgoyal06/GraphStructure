package com.lalit.undirected.Graph.operations;

import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.operations.GraphImpl;

/**
 * @author lalit goyal
 *
 */
public class UndirectedGraph extends GraphImpl implements UndirectedGraphCRUDOperations {

	@Override
	public boolean insertEdge(String nodeAName, String nodeBName, String edgeName) {
		// Create an Edge Constant time operations
		Edge edge = new Edge(edgeName);
		edge.setFromNode(nodeAName);
		edge.setToNode(nodeBName);
		edge.setDirectedEdge(false);
		edgeList.add(edge);
		// Best Case - 2*O(log(n)) - Both nodes already exists
		// Worst Case - 4*O(log(n)) - Both Nodes are new
		insertNode(nodeAName);
		insertNode(nodeBName);
		return true;
	}

}