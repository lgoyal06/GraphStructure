package com.lalit.directed.graph.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.elements.version2.Node;
import com.lalit.graph.operations.GraphCRUDOperations;

/**
 * @author lalit goyal
 * @param fromNodeName
 * @param toNodeName
 * @param edgeName
 * @return
 */
public class DirectedGraphOperationsImplViaListStructure implements GraphCRUDOperations {

	List<Edge> edgeList = new ArrayList<Edge>();
	Map<String, Node> nodeMap = new TreeMap<String, Node>();

	public Map<String, Node> getNodeMap() {
		return nodeMap;
	}

	public void setNodeMap(Map<String, Node> nodeMap) {
		this.nodeMap = nodeMap;
	}

	public List<Edge> getEdgeList() {
		return edgeList;
	}

	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}

	@Override
	public boolean insertOperation(String fromNodeName, String toNodeName, String edgeName) {
		// TODO Auto-generated method stub

		return false;
	}

	public Node insertNodeOperation(String fromNodeName) {
		Node node = new Node();
		node.setNodeName(fromNodeName);
		// O(logn) time operation
		return nodeMap.put(fromNodeName, node);
	}

	public Node insertNodeOperation(String nodeName, boolean isIncomingEdge, boolean isOutgoingEdge, String edgeName) {
		// Find the existing Node : Time Complexity O(logn)
		Node node = nodeMap.get(nodeName);
		if (node == null) {
			node = new Node();
			node.setNodeName(nodeName);
		}
		if (isIncomingEdge) {
			node.setIncomingEdgeToList(edgeName);
		} else if (isOutgoingEdge) {
			node.setOutGoingEdgeToList(edgeName);
		} else {
			node.setUndirectedEdgeToList(edgeName);
		}
		// Put into map : Time Complexity O(logn)
		return nodeMap.put(nodeName, node);
	}

	@Override
	public boolean insertDirectedEdgeOperation(String fromNodeName, String toNodeName, String edgeName) {
		// Create an Edge
		Edge edge = new Edge();
		edge.setNodeA(fromNodeName);
		edge.setNodeB(toNodeName);
		edge.setEdgeInformation(edgeName);
		edge.setDirectedEdge(true);
		edgeList.add(edge);

		// Insert the From and To Node to the nodeMap if not exist
		insertNodeOperation(fromNodeName, false, true, edgeName);
		insertNodeOperation(toNodeName, true, false, edgeName);

		return true;
	}

	@Override
	public boolean insertUndirectedEdgeOperation(String nodeA, String nodeB, String edgeName) {
		// Create an Edge
		Edge edge = new Edge();
		edge.setNodeA(nodeA);
		edge.setNodeB(nodeB);
		edge.setEdgeInformation(edgeName);
		edge.setDirectedEdge(false);
		edgeList.add(edge);

		// Insert the From and To Node to the nodeMap if not exist
		insertNodeOperation(nodeA, false, false, edgeName);
		insertNodeOperation(nodeB, false, false, edgeName);

		return true;
	}

	@Override
	public boolean deleteNodeOperation(String nodeToBeDeleted) {
		// O(logn) time complexity
		nodeMap.remove(nodeToBeDeleted);
		// TODO Find all the edges and remove the Edge from the edge list
		return false;
	}

	@Override
	public boolean deleteEdgeOperation(String edgeName) {
		// Time Complexity Worst - O(n) - remove the edge from the Graph
		// Average Complexity - O(n/2)
		edgeList.remove(edgeName);
		return false;
	}

	@Override
	public boolean updateNodeInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEdgeInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String... s) {
		DirectedGraphOperationsImplViaListStructure graph = new DirectedGraphOperationsImplViaListStructure();
		graph.insertNodeOperation("A");
		graph.insertNodeOperation("B");
		graph.insertNodeOperation("E");
		graph.insertDirectedEdgeOperation("B", "A", "Test");
		graph.insertDirectedEdgeOperation("C", "A", "EdgeFromCToA");
		graph.insertDirectedEdgeOperation("B", "C", "EdgeFromBToC");
		graph.insertUndirectedEdgeOperation("B", "D", "UndirectedEdgeFromBToD");
		System.out.println(graph);
	}
}