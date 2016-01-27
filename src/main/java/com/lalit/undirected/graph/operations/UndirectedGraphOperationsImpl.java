package com.lalit.undirected.graph.operations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.elements.version2.Node;
import com.lalit.graph.operations.Graph;
import com.lalit.graph.operations.UndirectedGraph;

public class UndirectedGraphOperationsImpl implements Graph, UndirectedGraph {

	private List<Edge> edgeList = new ArrayList<Edge>();
	private Map<String, Node> nodeMap = new TreeMap<String, Node>();

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
	public boolean deleteNode(String nodeToBeDeleted) {
		// TODO Complete by 29th Jan 2016 along with Time Complexity Study
		return false;
	}

	@Override
	public boolean deleteEdge(String edgeName) {
		// TODO Complete by 29th Jan 2016 along with Time Complexity Study
		return false;
	}

	@Override
	public boolean updateNodeInfo(String nodeNameId, String nodeInfo) {
		// TODO Complete by 29th Jan 2016 along with Time Complexity Study
		return false;
	}

	@Override
	public boolean updateEdgeInformation(String edgeName, String edgeInformation) {
		// TODO Complete by 29th Jan 2016 along with Time Complexity Study
		return false;
	}

	@Override
	public Iterator<? extends Edge> undirectedEdges() {
		// TODO Complete by 29th Jan 2016 along with Time Complexity Study
		return null;
	}

	@Override
	public boolean isDirected(String edgeName) {
		// TODO Complete by 29th Jan 2016 along with Time Complexity Study
		return false;
	}

	@Override
	public boolean isUndirected(String edgeName) {
		// TODO Complete by 29th Jan 2016 along with Time Complexity Study
		return false;
	}

}
