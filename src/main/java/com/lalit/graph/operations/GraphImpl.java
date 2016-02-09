package com.lalit.graph.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.elements.version2.Node;

/**
 * @author lalit goyal
 * @param fromNodeName
 * @param toNodeName
 * @param edgeName
 * @return
 * 
 */
public abstract class GraphImpl implements GraphCRUDOperations, GraphIteratorOperations<Node, Edge> {

	protected List<Edge> edgeList = new ArrayList<Edge>();
	protected Map<String, Node> nodeMap = new TreeMap<String, Node>();

	@Override
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
			if (nodeToBeDeleted.equals(e.getFromNode()) || nodeToBeDeleted.equals(e.getToNode())) {
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
			if (edgeName.equals(e.getEdgeInformation())) {
				e.setEdgeInformation(edgeInformation);
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<Entry<String, Node>> adjacentNodes(String nodeName) {
		Iterator<Edge> iterator = edgeList.iterator();
		Map<String, Node> adjacentNodesMap = new HashMap<>();
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (nodeName.equals(e.getToNode())) {
				// Constant-time performance for the basic operations (get and
				// put), assuming the hash function disperses the elements
				// properly among the buckets.
				adjacentNodesMap.put(e.getFromNode(), nodeMap.get(e.getFromNode()));
			} else if (nodeName.equals(e.getFromNode())) {
				// Constant-time performance for the basic operations (get and
				// put), assuming the hash function disperses the elements
				// properly among the buckets.
				adjacentNodesMap.put(e.getToNode(), nodeMap.get(e.getToNode()));
			}
		}
		return adjacentNodesMap.entrySet().iterator();
	}

	@Override
	public Iterator<Entry<String, Node>> nodes() {
		// TODO Find Expected Time complexity
		return nodeMap.entrySet().iterator();
	}

	@Override
	public Iterator<Edge> edges() {
		// TODO Find Expected Time complexity
		return edgeList.iterator();
	}

	@Override
	public int numNodes() {
		// Constant time operations
		return nodeMap.size();
	}

	@Override
	public int numEdges() {
		// Constant time operations
		return edgeList.size();
	}

	@Override
	public boolean areAdjacent(String nodeA, String nodeB) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		Iterator<Edge> iterator = edgeList.iterator();
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if ((nodeA.equals(e.getFromNode()) && nodeB.equals(e.getToNode()))
					|| nodeB.equals(e.getFromNode()) && nodeA.equals(e.getToNode())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String opposite(String node, String edge) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		Iterator<Edge> iterator = edgeList.iterator();
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (edge.equals(e.getEdgeInformation()) && (node.equals(e.getFromNode()))) {
				return e.getToNode();
			}
		}
		return null;
	}

	@Override
	public String[] endVertices(String edge) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		Iterator<Edge> iterator = edgeList.iterator();
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (edge.equals(e.getEdgeInformation())) {
				return new String[] { e.getToNode(), e.getFromNode() };
			}
		}
		return null;
	}

	@Override
	public int degree(String nodeNameId) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		int counter = 0;
		Iterator<Edge> iterator = edgeList.iterator();
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (e.getToNode().equals(nodeNameId) || e.getFromNode().equals(nodeNameId)) {
				++counter;
			}
		}
		return counter;
	}

	@Override
	public Iterator<Edge> incidentEdges(String nodeName) {
		List<Edge> incidentEdges = new ArrayList<>();
		Iterator<Edge> iterator = edgeList.iterator();
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (nodeName.equals(e.getFromNode()) || nodeName.equals(e.getToNode())) {
				// Constant time to add element to array at end :: O(1)
				incidentEdges.add(e);
			}
		}
		return incidentEdges.iterator();
	}

	public boolean isNodeExists(String node) {
		return nodeMap.get(node) == null ? false : true;
	}

}