package com.lalit.directed.graph.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
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
public class DirectedGraph extends GraphImpl
		implements DirectedGraphCRUDOperations, DirectedGraphIteratorOperation<Node, Edge> {

	@Override
	public boolean insertEdge(String fromNodeName, String toNodeName, String edgeName) {
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

	@Override
	public boolean reverseDirection(String edgeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		ListIterator<Edge> listIterator = edgeList.listIterator();
		while (listIterator.hasNext()) {
			Edge e = listIterator.next();
			if (edgeName.equals(e.getEdgeInformation())) {
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
			if (edgeName.equals(e.getEdgeInformation())) {
				// Best Case - O(log(n)) - Both nodes already exists
				// Worst Case - 2*O(log(n)) - Both Nodes are new
				insertNode(newFromNodeName);
				e.setFromNode(newFromNodeName);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean setDirectionTo(String edgeName, String newToNodeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		ListIterator<Edge> listIterator = edgeList.listIterator();
		while (listIterator.hasNext()) {
			Edge e = listIterator.next();
			if (edgeName.equals(e.getEdgeInformation())) {
				// Best Case - O(log(n)) - Both nodes already exists
				// Worst Case - 2*O(log(n)) - Both Nodes are new
				insertNode(newToNodeName);
				e.setToNode(newToNodeName);
				return true;
			}
		}
		return false;
	}

	@Override
	public String destination(String edgeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		ListIterator<Edge> listIterator = edgeList.listIterator();
		while (listIterator.hasNext()) {
			Edge e = listIterator.next();
			if (edgeName.equals(e.getEdgeInformation())) {
				return e.getToNode();
			}
		}
		return null;
	}

	@Override
	public String origin(String edgeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		ListIterator<Edge> listIterator = edgeList.listIterator();
		while (listIterator.hasNext()) {
			Edge e = listIterator.next();
			if (edgeName.equals(e.getEdgeInformation())) {
				return e.getFromNode();
			}
		}
		return null;
	}

	@Override
	public int inDegree(String nodeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		int counter = 0;
		Iterator<Edge> iterator = edgeList.iterator();
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (nodeName.equals(e.getToNode())) {
				++counter;
			}
		}
		return counter;
	}

	@Override
	public int outDegree(String nodeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		int counter = 0;
		Iterator<Edge> iterator = edgeList.iterator();
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (nodeName.equals(e.getFromNode())) {
				++counter;
			}
		}
		return counter;
	}

	@Override
	public Iterator<Edge> inIncidentEdges(String nodeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		List<Edge> inIncidentEdges = new ArrayList<>();
		Iterator<Edge> iterator = edgeList.iterator();
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (nodeName.equals(e.getToNode())) {
				// Constant time to add element to array at end :: O(1)
				inIncidentEdges.add(e);
			}
		}
		return inIncidentEdges.iterator();
	}

	@Override
	public Iterator<Edge> outIncidentEdges(String nodeName) {
		List<Edge> outIncidentEdges = new ArrayList<>();
		Iterator<Edge> iterator = edgeList.iterator();
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (nodeName.equals(e.getFromNode())) {
				// Constant time to add element to array at end :: O(1)
				outIncidentEdges.add(e);
			}
		}
		return outIncidentEdges.iterator();
	}

	@Override
	public Iterator<Entry<String, Node>> inAdjacentNodes(String nodeName) {
		Iterator<Edge> iterator = edgeList.iterator();
		Map<String, Node> inAdjacentNodesMap = new HashMap<>();
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (nodeName.equals(e.getToNode())) {
				// Constant-time performance for the basic operations (get and
				// put), assuming the hash function disperses the elements
				// properly among the buckets.
				inAdjacentNodesMap.put(e.getFromNode(), nodeMap.get(e.getFromNode()));
			}
		}
		return inAdjacentNodesMap.entrySet().iterator();
	}

	@Override
	public Iterator<Entry<String, Node>> outAdjacentNodes(String nodeName) {
		// Constant time in object creation
		Map<String, Node> outAdjacentNodesMap = new HashMap<>();
		Iterator<Edge> iterator = edgeList.iterator();
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (nodeName.equals(e.getFromNode())) {
				// Constant-time performance for the basic operations (get and
				// put), assuming the hash function disperses the elements
				// properly among the buckets.
				outAdjacentNodesMap.put(e.getToNode(), nodeMap.get(e.getToNode()));
			}
		}
		return outAdjacentNodesMap.entrySet().iterator();
	}

}