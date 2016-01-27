package com.lalit.directed.graph.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.elements.version2.Node;
import com.lalit.graph.operations.DirectedGraph;

/**
 * @author lalit goyal
 * @param fromNodeName
 * @param toNodeName
 * @param edgeName
 * @return
 * 
 * 		TODO: Complete study of the Time Complexity by Dated 29th Jan 2016
 */
public class DirectedGraphImpl implements DirectedGraph {

	private List<Edge> edgeList = new ArrayList<Edge>();
	private Map<String, Node> nodeMap = new TreeMap<String, Node>();

	public Node insertNode(String nodeName) {
		// Time Complexity O(log(n)) Search an element in TreeMap
		Node node = nodeMap.get(nodeName);
		if (node == null) {
			node = new Node();
			node.setNodeNameInfo(nodeName);
			// O(log(n)) - add operation in TreeMap
			return nodeMap.put(nodeName, node);
		}
		return node;
	}

	@Override
	public boolean insertDirectedEdge(String fromNodeName, String toNodeName, String edgeName) {
		// Create an Edge Constant time operations
		Edge edge = new Edge(edgeName);
		edge.setFromNode(fromNodeName);
		edge.setToNode(toNodeName);
		edge.setDirectedEdge(true);
		edgeList.add(edge);
		// Best Case - 2*O(log(n)) - Both nodes already exists
		// Worst Case - 4*O(log(n)) - Both Nodes are new
		insertNode(fromNodeName);
		insertNode(toNodeName);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lalit.graph.operations.GraphCRUDOperations#
	 * insertUndirectedEdgeOperation(java.lang.String, java.lang.String,
	 * java.lang.String)
	 * 
	 * Assumption : edgeName will be unique i.e. no two EdgeName can be same
	 */
	@Override
	public boolean insertUndirectedEdge(String nodeA, String nodeB, String edgeName) {
		// Create an Edge
		// TODO check in case edge already exists
		Edge edge = new Edge(edgeName);
		edge.setFromNode(nodeA);
		edge.setToNode(nodeB);
		edge.setDirectedEdge(false);
		edgeList.add(edge);
		// Best Case - 2*O(log(n)) - Both nodes already exists
		// Worst Case - 4*O(log(n)) - Both Nodes are new
		insertNode(nodeA);
		insertNode(nodeB);
		return true;
	}

	@Override
	public boolean deleteNode(String nodeToBeDeleted) {
		// O(log(n)) time complexity
		nodeMap.remove(nodeToBeDeleted);
		// O(e) - e is the total number of the edges
		ListIterator<Edge> listIterator = edgeList.listIterator();
		while (listIterator.hasNext()) {
			Edge e = listIterator.next();
			if (e.getFromNode().equalsIgnoreCase(nodeToBeDeleted) || e.getToNode().equalsIgnoreCase(nodeToBeDeleted)) {
				listIterator.remove();
			}
		}
		return true;
	}

	@Override
	public boolean deleteEdge(String edgeName) {
		// Time Complexity Worst - O(n) - remove the edge from the Graph
		// Average Complexity - O(n/2)
		return edgeList.remove(new Edge(edgeName));
	}

	@Override
	public boolean updateNodeInfo(String nodeNameId, String nodeInfo) {
		// Time Complexity :: O(log(n))
		Node node = nodeMap.get(nodeNameId);
		if (node != null) {
			node.setNodeNameInfo(nodeInfo);
			return true;
		}
		return false;
	}

	@Override
	public boolean makeUndirected(String edgeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		ListIterator<Edge> listIterator = edgeList.listIterator();
		while (listIterator.hasNext()) {
			Edge e = listIterator.next();
			if (e.getEdgeInformation().equalsIgnoreCase(edgeName)) {
				e.setDirectedEdge(false);
				return true;
			}
		}
		return false;

	}

	@Override
	public boolean reverseDirection(String edgeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		ListIterator<Edge> listIterator = edgeList.listIterator();
		while (listIterator.hasNext()) {
			Edge e = listIterator.next();
			if (e.getEdgeInformation().equalsIgnoreCase(edgeName)) {
				String toNode = e.getToNode();
				String fromNode = e.getFromNode();
				e.setToNode(fromNode);
				e.setFromNode(toNode);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean setDirectionFrom(String edgeName, String newFromNodeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		ListIterator<Edge> listIterator = edgeList.listIterator();
		while (listIterator.hasNext()) {
			Edge e = listIterator.next();
			if (e.getEdgeInformation().equalsIgnoreCase(edgeName)) {
				e.setFromNode(newFromNodeName);
				// Best Case - O(log(n)) - Both nodes already exists
				// Worst Case - 2*O(log(n)) - Both Nodes are new
				insertNode(newFromNodeName);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean setDirectionTo(String edgeName, String newToNodeName) {
		ListIterator<Edge> listIterator = edgeList.listIterator();
		while (listIterator.hasNext()) {
			Edge e = listIterator.next();
			if (e.getEdgeInformation().equalsIgnoreCase(edgeName)) {
				e.setToNode(newToNodeName);
				// Best Case - O(log(n)) - Both nodes already exists
				// Worst Case - 2*O(log(n)) - Both Nodes are new
				insertNode(newToNodeName);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateEdgeInformation(String edgeName, String edgeInformation) {
		ListIterator<Edge> listIterator = edgeList.listIterator();
		while (listIterator.hasNext()) {
			Edge e = listIterator.next();
			if (e.getEdgeInformation().equalsIgnoreCase(edgeName)) {
				e.setEdgeInformation(edgeInformation);
				return true;
			}
		}
		return false;
	}
}