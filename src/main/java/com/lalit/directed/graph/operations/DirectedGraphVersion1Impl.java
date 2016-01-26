package com.lalit.directed.graph.operations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.lalit.graph.elements.Edge;
import com.lalit.graph.operations.DirectedGraph;

/**
 * @author lalit goyal
 * @param fromNodeName
 * @param toNodeName
 * @param edgeName
 * @return
 */
public class DirectedGraphVersion1Impl implements DirectedGraph {

	Map<String, Set<Edge>> graphMap = new TreeMap<>();

	/**
	 * <p>
	 * Time Complexity is 4(logn)+C1+C2+C3+C4. As per the Big-oh notations
	 * theorem log(n^x) is log(n) So to add one element to the Graph time
	 * complexity is ~ O(logn)
	 * </p>
	 * 
	 * TODO 1. Finish the Logic addOperation , 2. JUnit test cases by 22nd Jan
	 * 2016
	 * 
	 * @param fromNodeName
	 * @param toNodeName
	 * @param edgeName
	 * @return
	 */

	public boolean insert(String fromNodeName, String toNodeName, String edgeName) {
		try {
			// O(logn)
			if (!graphMap.containsKey(fromNodeName)) {
				// O(logn)
				graphMap.put(fromNodeName, null);
			}
			// CC4-Constant time operations
			if (toNodeName != null && !toNodeName.equalsIgnoreCase("")) {
				// Constant time operation - C1
				Edge edge = new Edge(edgeName, toNodeName);
				// O(logn)
				Set<Edge> edgeSet = graphMap.get(fromNodeName);
				if (edgeSet == null) {
					// Constant time operation - C2
					edgeSet = new HashSet<Edge>();
				}
				// Constant time operation - C3
				edgeSet.add(edge);
				// O(logn)
				graphMap.put(fromNodeName, edgeSet);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean insertEdge(String fromNodeName, String toNodeName, String edgeName) {
		return false;

	}

	// TODO:Fix it by 22nd Jan 2016
	/**
	 * Challenge : With current Concrete DS i.e. graph as Map Structure, it will
	 * take around 0(n*e) ~ O(n^2) time to delete a Node from graph
	 * 
	 * > O(logn) - Remove the NodeA from map including all outgoing edges for
	 * NodeA
	 * 
	 * > O((n-1)*e) - Time to remove incoming edges for NodeA.
	 * 
	 * > Total Time Complexity comes out to be approximate O(n^2)
	 * 
	 * Solution :: Build the structure using the List CDS Refer to the file for
	 * few days --->> DirectedGraphOperationsImplViaListStructure.java
	 * 
	 **/
	public boolean deleteNode(String nodeToBeDeleted) {

		/**
		 * To delete the Node and outgoing Edge--> Iterate over map and delete
		 * 
		 * Delete incoming Edges for Node --> Now iterate over all key of Map
		 * and remove the incoming Edge
		 **/

		return false;
	}

	// TODO:Fix it by 22nd Jan 2016
	public boolean deleteEdge(String edgeName) {
		return false;
	}

	// TODO:Fix it by 23rd-24th Jan 2016
	public boolean updateNodeInfo() {
		return false;

	}

	// TODO:Fix it by 23rd-24th Jan 2016
	public boolean updateEdgeInfo() {
		return false;
	}

	@Override
	public Object insertNode(String fromNodeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertDirectedEdge(String fromNodeName, String toNodeName, String edgeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertUndirectedEdge(String nodeA, String nodeB, String edgeName) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String... s) {
		DirectedGraphVersion1Impl graphOperation = new DirectedGraphVersion1Impl();
		graphOperation.insert("A", "B", "");
		graphOperation.insert("B", "C", "");
		graphOperation.insert("C", "A", "");
		graphOperation.insert("C", "B", "");
		graphOperation.insert("A", "B", "HELLO");
		graphOperation.insert("C", "D", "HELLO");
		for (String key : graphOperation.graphMap.keySet()) {
			Iterator<Edge> it = graphOperation.graphMap.get(key).iterator();
			System.out.println(key + " Friend List::");
			while (it.hasNext()) {
				Edge edge = it.next();
				System.out.println("\t" + edge.getConnectedNodeName());
			}
		}
	}

	@Override
	public boolean updateNodeInfo(String nodeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean makeUndirected(String edgeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reverseDirection(String edgeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setDirectionFrom(String edgeName, String newFromNodeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setDirectionTo(String edgeName, String newToNodeName) {
		// TODO Auto-generated method stub
		return false;
	}
}