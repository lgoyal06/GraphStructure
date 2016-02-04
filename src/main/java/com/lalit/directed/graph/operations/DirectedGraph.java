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
public class DirectedGraph extends GraphImpl implements DirectedGraphCRUDOperations, DirectedGraphIteratorOperation {

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
			if (e.getEdgeInformation().equalsIgnoreCase(edgeName)) {
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
			if (e.getEdgeInformation().equalsIgnoreCase(edgeName) && e.isDirectedEdge()) {
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
			if (e.getEdgeInformation().equalsIgnoreCase(edgeName) && e.isDirectedEdge()) {
				return e.getFromNode();
			}
		}
		return null;
	}

	@Override
	public Iterator<? extends Edge> directedEdges() {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		List<Edge> directedEdges = new ArrayList<>();
		ListIterator<Edge> listIterator = edgeList.listIterator();
		while (listIterator.hasNext()) {
			Edge e = listIterator.next();
			if (e.isDirectedEdge()) {
				// Constant time to add element to array at end :: O(1)
				directedEdges.add(e);
			}
		}
		return directedEdges.iterator();
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
			if (e.getToNode().equalsIgnoreCase(nodeName) && e.isDirectedEdge()) {
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
			if (e.getFromNode().equalsIgnoreCase(nodeName) && e.isDirectedEdge()) {
				++counter;
			}
		}
		return counter;
	}

	@Override
	public Iterator<? extends Edge> inIncidentEdges(String nodeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		List<Edge> inIncidentEdges = new ArrayList<>();
		Iterator<Edge> iterator = edgeList.iterator();
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (e.getToNode().equalsIgnoreCase(nodeName) && e.isDirectedEdge()) {
				// Constant time to add element to array at end :: O(1)
				inIncidentEdges.add(e);
			}
		}
		return inIncidentEdges.iterator();
	}

	@Override
	public Iterator<? extends Edge> outIncidentEdges(String nodeName) {
		List<Edge> outIncidentEdges = new ArrayList<>();
		Iterator<Edge> iterator = edgeList.iterator();
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (e.getFromNode().equalsIgnoreCase(nodeName) && e.isDirectedEdge()) {
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
			if (e.getToNode().equalsIgnoreCase(nodeName) && e.isDirectedEdge()) {
				// Constant-time performance for the basic operations (get and
				// put), assuming the hash function disperses the elements
				// properly among the buckets.
				inAdjacentNodesMap.put(nodeName, nodeMap.get(nodeName));
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
			if (e.getToNode().equalsIgnoreCase(nodeName) && e.isDirectedEdge()) {
				// Constant-time performance for the basic operations (get and
				// put), assuming the hash function disperses the elements
				// properly among the buckets.
				outAdjacentNodesMap.put(nodeName, nodeMap.get(nodeName));
			}
		}
		return outAdjacentNodesMap.entrySet().iterator();
	}

}