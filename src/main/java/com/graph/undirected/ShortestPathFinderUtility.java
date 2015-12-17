package com.graph.undirected;

import java.util.Map;

/**
 * @author lalit goyal
 * 
 *         Utility to find the Shortest path for the Directed Graph
 *
 */
public class ShortestPathFinderUtility {

	public static void main(String... s) throws Exception {
		System.out.println(isPathExistsBetweenTwoNodes("Houston2", "Las Vegas"));
	}

	public static boolean isPathExistsBetweenTwoNodes(String source, String destination) {
		Map<String, Node<Edge>> map = getMapStructure();
		Stack<String> stackOfNodesToBeProcessed = new Stack<String>();
		stackOfNodesToBeProcessed.push(source);
		while ((!stackOfNodesToBeProcessed.containsElement(destination)) && stackOfNodesToBeProcessed.size() > 0) {
			Node<Edge> value = map.get(stackOfNodesToBeProcessed.pop());
			if (value != null) {
				for (Edge edge : value.getEdgeList()) {
					stackOfNodesToBeProcessed.push(edge.getConnectedNodeName());
				}
			}
		}
		return stackOfNodesToBeProcessed.containsElement(destination);
	}

	private static Map<String, Node<Edge>> getMapStructure() {
		GraphToMapStructureBuilder mapBuilder = new GraphToMapStructureBuilderImpl();
		Map<String, Node<Edge>> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\workspace\\GraphStructureLearning\\src\\main\\java\\com\\graph\\undirected\\SampleInputFile");
		return map;
	}
}