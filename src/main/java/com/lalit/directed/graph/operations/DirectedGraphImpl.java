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

	@Override
	public boolean insert(String fromNodeName, String toNodeName, String edgeName) {
		return false;
	}

	public Node insertNode(String nodeName) {
		// Time Complexity O(logn) Search an element in TreeMap
		Node node = nodeMap.get(nodeName);
		if (node == null) {
			node = new Node();
			node.setNodeName(nodeName);
		}
		// O(logn) - add operation in TreeMap
		return nodeMap.put(nodeName, node);
	}

	@Override
	public boolean insertDirectedEdge(String fromNodeName, String toNodeName, String edgeName) {
		// Create an Edge
		Edge edge = new Edge(edgeName);
		edge.setFromNode(fromNodeName);
		edge.setToNode(toNodeName);
		edge.setDirectedEdge(true);
		edgeList.add(edge);
		// Insert the From and To Node to the nodeMap if not exist 4*O(logn)
		// time complexity
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
		// Insert the From and To Node to the nodeMap if not exist
		insertNode(nodeA);
		insertNode(nodeB);
		return true;
	}

	@Override
	public boolean deleteNode(String nodeToBeDeleted) {
		// O(logn) time complexity
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
	public boolean updateNodeInfo(String nodeName) {
		// TODO Dated 27th Jan 2016
		return false;
	}

	@Override
	public boolean makeUndirected(String edgeName) {
		// TODO Dated 27th Jan 2016
		return false;
	}

	@Override
	public boolean reverseDirection(String edgeName) {
		// TODO Dated 27th Jan 2016
		return false;
	}

	@Override
	public boolean setDirectionFrom(String edgeName, String newFromNodeName) {
		// TODO Dated 27th Jan 2016
		return false;
	}

	@Override
	public boolean setDirectionTo(String edgeName, String newToNodeName) {
		// TODO Dated 27th Jan 2016
		return false;
	}

}