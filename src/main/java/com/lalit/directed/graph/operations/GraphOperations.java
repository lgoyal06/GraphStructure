package com.lalit.directed.graph.operations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.lalit.graph.elements.Edge;

/**
 * @author lalit goyal
 * @param fromNodeName
 * @param toNodeName
 * @param edgeName
 * @return
 */
public class GraphOperations {

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

	public boolean addOperation(String fromNodeName, String toNodeName, String edgeName) {
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

	// TODO:Fix it by 22nd Jan 2016
	public boolean deleteNodeOperation(String nodeToBeDeleted) {
		return false;

	}

	// TODO:Fix it
	public boolean deleteEdgeOperation(String toNodeName, String edgeName) {
		return false;
	}

	public static void main(String... s) {
		GraphOperations graphOperation = new GraphOperations();
		graphOperation.addOperation("A", "B", "");
		graphOperation.addOperation("B", "C", "");
		graphOperation.addOperation("C", "A", "");
		graphOperation.addOperation("A", "B", "HELLO");
		graphOperation.addOperation("C", "D", "HELLO");
		for (String key : graphOperation.graphMap.keySet()) {
			Iterator<Edge> it = graphOperation.graphMap.get(key).iterator();
			System.out.println(key + " Friend List::");
			while (it.hasNext()) {
				Edge edge = it.next();
				System.out.println("\t" + edge.getConnectedNodeName());
			}
		}
	}
}