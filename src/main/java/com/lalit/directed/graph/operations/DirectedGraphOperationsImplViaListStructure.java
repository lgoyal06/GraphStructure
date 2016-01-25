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

	private List<Edge> edgeList = new ArrayList<Edge>();
	private Map<String, Node> nodeMap = new TreeMap<String, Node>();

	@Override
	public boolean insert(String fromNodeName, String toNodeName, String edgeName) {
		// TODO Auto-generated method stub

		return false;
	}

	public Node insertNode(String nodeName) {
		Node node = new Node();
		node.setNodeName(nodeName);
		// O(logn) time operation
		return nodeMap.put(nodeName, node);
	}

	public Node insertNode(String nodeName, boolean isIncomingEdge, boolean isOutgoingEdge, String edgeName) {
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
	public boolean insertDirectedEdge(String fromNodeName, String toNodeName, String edgeName) {
		// Create an Edge
		Edge edge = new Edge();
		edge.setNodeA(fromNodeName);
		edge.setNodeB(toNodeName);
		edge.setEdgeInformation(edgeName);
		edge.setDirectedEdge(true);
		edgeList.add(edge);

		// Insert the From and To Node to the nodeMap if not exist
		insertNode(fromNodeName, false, true, edgeName);
		insertNode(toNodeName, true, false, edgeName);

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
		Edge edge = new Edge();
		edge.setNodeA(nodeA);
		edge.setNodeB(nodeB);
		edge.setEdgeInformation(edgeName);
		edge.setDirectedEdge(false);
		edgeList.add(edge);

		// Insert the From and To Node to the nodeMap if not exist
		insertNode(nodeA, false, false, edgeName);
		insertNode(nodeB, false, false, edgeName);

		return true;
	}

	@Override
	public boolean deleteNode(String nodeToBeDeleted) {
		// TODO 1. Remove all incoming,outgoing and undirected Edges of
		// nodeTobedeleted from nodeMap
		// 2.Remove incoming,outgoing and undirected Edges of few of other Nodes
		// from nodeMap
		// 3.Remove the edges from the edgelist

		/**
		 * TODO Option 1: iterate over the edgeList and remove edges containing
		 * nodeToBeDeleted. Also remove delete edges from Other Nodes in nodeMap
		 * 
		 * Time Complexity::> O(e) (to iterate over all edges)+O(e) to delete
		 * the edge that requires the re shuffling +O(n)+O(size of edges for
		 * each node)(iterate over all nodes and remove the edges from the node
		 * 
		 * 
		 * Option 2 : Get the list of all incoming,outgoing and undirected Edges
		 * of nodeToBedeleted and then delete it from the edgelist. Also remove
		 * delete edges from Other Nodes in nodeMap
		 * 
		 * Time Complexity :::> O(logn) to find the node Let m is the size of
		 * all edges from the node then time complexity to delete the nodes from
		 * the edgelist is O(e) worst case to find the edge and then O(e)to
		 * perform the re shuffling Total time complexity would be around
		 * 2m*O(e) which is ~ o(e) as per the theorem of Big-oh notation
		 * 
		 * +O(n)+O(size of edges for each node)(iterate over all nodes and
		 * remove the edges from the node
		 * 
		 **/

		// O(logn) time complexity
		nodeMap.remove(nodeToBeDeleted);
		return false;
	}

	@Override
	public boolean deleteEdge(String edgeName) {
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
		graph.insertNode("A");
		graph.insertNode("B");
		graph.insertNode("E");
		graph.insertDirectedEdge("B", "A", "Test");
		graph.insertDirectedEdge("C", "A", "EdgeFromCToA");
		graph.insertDirectedEdge("B", "C", "EdgeFromBToC");
		graph.insertUndirectedEdge("B", "D", "UndirectedEdgeFromBToD");
		System.out.println(graph);
	}

}