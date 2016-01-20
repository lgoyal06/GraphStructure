package com.lalit.undirected.graph.operations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.lalit.graph.elements.Edge;

public class GraphOperations {

	Map<String, List<Edge>> graphMap = new TreeMap<>();

	// TODO Graph Add Operation
	private boolean addOperation(String nodeName, String connectedNode, String edgeName) {
		// Logic In progress
		if (graphMap.containsKey(nodeName)) {
			if (connectedNode != null) {
				Iterator<Edge> it = graphMap.get(nodeName).iterator();
				while (it.hasNext()) {
					if (it.next().getConnectedNodeName().equals(connectedNode))
						return false;
				}
				Edge edge = new Edge(edgeName, connectedNode);
				List<Edge> list = new ArrayList<>();
				list.add(edge);
			}
		}

		return false;

	}

	public static void main(String... s) {
		new GraphOperations().addOperation("A", "B", "");
	}

}
