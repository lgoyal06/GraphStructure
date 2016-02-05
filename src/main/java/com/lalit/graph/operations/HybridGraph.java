package com.lalit.graph.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import com.lalit.directed.graph.operations.DirectedGraphCRUDOperations;
import com.lalit.directed.graph.operations.DirectedGraphIteratorOperation;
import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.elements.version2.Node;
import com.lalit.undirected.Graph.operations.UndirectedGraphCRUDOperations;

/**
 * @author lalit goyal
 * 
 *         TODO Think of avoiding the code redundancy
 */
public class HybridGraph extends GraphImpl
		implements DirectedGraphCRUDOperations, DirectedGraphIteratorOperation<Node, Edge>,
		UndirectedGraphCRUDOperations, HybridGraphCRUDOperations, HybridGraphIteratorOperations<Edge> {

	@Override
	public boolean isDirected(String edgeName) {
		return !isUndirected(edgeName);
	}

	@Override
	public boolean isUndirected(String edgeName) {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		Iterator<Edge> iterator = edgeList.iterator();
		while (iterator.hasNext()) {
			Edge e = iterator.next();
			if (edgeName.equals(e.getEdgeInformation())) {
				return e.isDirectedEdge();
			}
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
			if (e.getEdgeInformation().equals(edgeName)) {
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
			if (e.getEdgeInformation().equals(edgeName)) {
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
			if (e.getEdgeInformation().equals(edgeName)) {
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
			if (e.getEdgeInformation().equals(edgeName)) {
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
			if (e.getEdgeInformation().equals(edgeName) && e.isDirectedEdge()) {
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
			if (e.getEdgeInformation().equals(edgeName) && e.isDirectedEdge()) {
				return e.getFromNode();
			}
		}
		return null;
	}

	@Override
	public Iterator<Edge> directedEdges() {
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
			if (e.getToNode().equals(nodeName) && e.isDirectedEdge()) {
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
			if (e.getFromNode().equals(nodeName) && e.isDirectedEdge()) {
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
			if (e.getToNode().equals(nodeName) && e.isDirectedEdge()) {
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
			if (e.getFromNode().equals(nodeName) && e.isDirectedEdge()) {
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
			if (e.getToNode().equals(nodeName) && e.isDirectedEdge()) {
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
			if (e.getFromNode().equals(nodeName) && e.isDirectedEdge()) {
				// Constant-time performance for the basic operations (get and
				// put), assuming the hash function disperses the elements
				// properly among the buckets.
				outAdjacentNodesMap.put(e.getToNode(), nodeMap.get(e.getToNode()));
			}
		}
		return outAdjacentNodesMap.entrySet().iterator();
	}

	@Override
	public Iterator<Edge> undirectedEdges() {
		// Worst Case - O(e) - e total number of the edges for all nodes
		// Best Case - O(1)
		// Average Case - O(e/2)
		List<Edge> unDirectedEdges = new ArrayList<>();
		ListIterator<Edge> listIterator = edgeList.listIterator();
		while (listIterator.hasNext()) {
			Edge e = listIterator.next();
			if (!e.isDirectedEdge()) {
				// Constant time to add element to array at end :: O(1)
				unDirectedEdges.add(e);
			}
		}
		return unDirectedEdges.iterator();
	}

	@Override
	public boolean insertDirectedEdge(String fromNodeName, String toNodeName, String edgeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertUndirectedEdge(String fromNodeName, String toNodeName, String edgeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numDirectedNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numUndirectedNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numDirectedEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numUndirectedEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertEdge(String fromNodeName, String toNodeName, String edgeName) {
		// TODO Auto-generated method stub
		return false;
	}

}