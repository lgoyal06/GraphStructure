package com.lalit.undirected.Graph.operations;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map.Entry;

import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.elements.version2.Node;
import com.lalit.graph.operations.GraphImpl;

/**
 * @author lalit goyal
 * @param fromNodeName
 * @param toNodeName
 * @param edgeName
 * @return
 * 
 */
public class UndirectedGraph extends GraphImpl implements UndirectedGraphCRUDOperations, UndirectedGraphIterator {

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
	public boolean deleteNode(String nodeToBeDeleted) {
		// O(log(n)) time complexity
		nodeMap.remove(nodeToBeDeleted);
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
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
		// Does not seems be the best solution see it and fix it
		// Time Complexity Worst - O(n) - remove the edge from the Graph
		// Average Complexity - O(n/2)
		return edgeList.remove(new Edge(edgeName));
	}

	@Override
	public boolean updateNodeInfo(String nodeName, String nodeInfo) {
		// Time Complexity :: O(log(n))
		Node node = nodeMap.get(nodeName);
		if (node != null) {
			node.setNodeNameInfo(nodeInfo);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEdgeInformation(String edgeName, String edgeInformation) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
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

	@Override
	public boolean isDirected(String edgeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		Iterator<Edge> iterator = edgeList.iterator();
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (e.getEdgeInformation().equalsIgnoreCase(edgeName)) {
				return e.isDirectedEdge();
			}
		}
		return false;
	}

	@Override
	public boolean isUndirected(String edgeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		Iterator<Edge> iterator = edgeList.iterator();
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (e.getEdgeInformation().equalsIgnoreCase(edgeName)) {
				return e.isDirectedEdge();
			}
		}
		return false;
	}

	@Override
	public Iterator<? extends Edge> incidentEdges(String nodeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Entry<String, Node>> adjacentNodes(String nodeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Entry<String, Node>> nodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<? extends Edge> edges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertUndirectedEdge(String nodeAName, String nodeBName, String edgeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int degree(String nodeNameId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean areAdjacent(String nodeA, String nodeB) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String opposite(String node, String edge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] endVertices(String edge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<? extends Edge> undirectedEdges() {
		// TODO Auto-generated method stub
		return null;
	}
}