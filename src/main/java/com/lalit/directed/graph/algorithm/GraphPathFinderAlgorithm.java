package com.lalit.directed.graph.algorithm;

import static com.lalit.graph.utility.CommonUtils.deepCopyOfList;
import static com.lalit.graph.utility.CommonUtils.isDuplicateElementInStringArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.lalit.graph.elements.Edge;
import com.lalit.graph.elements.Node;
import com.lalit.graph.utility.Stack;
import com.lalit.graph.utility.ValueComparator;

/**
 * @author lalit goyal
 * 
 *         Utility to find the Shortest path between Nodes for the Directed
 *         Graph
 * 
 *         String[0] -> Name of the node
 * 
 *         String[1] -> Distance/Weight from connected node
 * 
 *         TODO: Change the Class Name to make it more easy to understand and
 *         relate with task it is performing
 * 
 *         TODO: See can DFS Graph traversal logic on 303 Page of Algorithm
 *         Design
 * 
 */
public final class GraphPathFinderAlgorithm {

	public Map<String, Integer> findShortestPathAndDistanceBtwTwoNodesInDirectedGraph(Map<String, Node> graphMap,
			String startingNode, String destinationNode) {
		Map<String, Integer> sortedMapOfAllPossiblePathsBtwTwoNodes = findAllPossiblePathsBetweenTwoNodes(graphMap,
				startingNode, destinationNode);
		Map<String, Integer> finalMapWithShortestPath = new HashMap<>();
		for (Entry<String, Integer> entry : sortedMapOfAllPossiblePathsBtwTwoNodes.entrySet()) {
			finalMapWithShortestPath.put(entry.getKey(), entry.getValue());
			return finalMapWithShortestPath;
		}
		finalMapWithShortestPath.put("", -1);
		return finalMapWithShortestPath;
	}

	public Map<String, Integer> findAllPossiblePathsBetweenTwoNodes(Map<String, Node> graphMap, String startingNode,
			String destinationNode) {
		Stack<String[]> depthFirstTraverseStack = new Stack<String[]>();
		depthFirstTraverseStack.push(new String[] { startingNode, "0" });
		Stack<String[]> buildPathStack = new Stack<String[]>();
		Map<String, Integer> mapOfAllPossiblePathsBtwTwoNodes = new HashMap<>();
		while (depthFirstTraverseStack.size() > 0) {
			String[] currentNodeInfo = depthFirstTraverseStack.peek();
			if (currentNodeInfo[0].equalsIgnoreCase(destinationNode))
				addNewPathToPossiblePathsList(depthFirstTraverseStack, buildPathStack,
						mapOfAllPossiblePathsBtwTwoNodes);
			else {
				if (buildPathStack.size() > 0 && currentNodeInfo[0].equalsIgnoreCase(buildPathStack.peek()[0])) {
					depthFirstTraverseStack.pop();
					buildPathStack.pop();
				} else {
					Node node = graphMap.get(currentNodeInfo[0]);
					if (!isCurrentNodeAlreadyExistInDFTStack(depthFirstTraverseStack, currentNodeInfo[0])
							&& isEgdeExistsForCurrentNode(depthFirstTraverseStack, currentNodeInfo[0], node)) {
						addAllConnectedNodesToDFTStack(depthFirstTraverseStack, node);
						buildPathStack.push(currentNodeInfo);
					} else
						depthFirstTraverseStack.pop();
				}
			}
		}
		return sortMapByValueAscending(mapOfAllPossiblePathsBtwTwoNodes);
	}

	private Map<String, Integer> sortMapByValueAscending(Map<String, Integer> mapOfAllPossiblePathsBtwTwoNodes) {
		ValueComparator vc = new ValueComparator(mapOfAllPossiblePathsBtwTwoNodes);
		TreeMap<String, Integer> sortedMapOfAllPossiblePathsBtwTwoNodes = new TreeMap<String, Integer>(vc);
		sortedMapOfAllPossiblePathsBtwTwoNodes.putAll(mapOfAllPossiblePathsBtwTwoNodes);
		return sortedMapOfAllPossiblePathsBtwTwoNodes;
	}

	private void addNewPathToPossiblePathsList(Stack<String[]> depthFirstTraverseStack, Stack<String[]> buildPathStack,
			Map<String, Integer> mapOfAllPossiblePathsBtwTwoNodes) {
		buildPathStack.push(depthFirstTraverseStack.pop());
		List<String[]> listDeepCopy = deepCopyOfList(buildPathStack.list());
		pathAlongWithDistance(mapOfAllPossiblePathsBtwTwoNodes, listDeepCopy);
		buildPathStack.pop();
	}

	private boolean isCurrentNodeAlreadyExistInDFTStack(Stack<String[]> depthFirstTraverseStack, String currentNode) {
		return isDuplicateElementInStringArrayList(depthFirstTraverseStack.list(), currentNode);
	}

	private boolean isEgdeExistsForCurrentNode(Stack<String[]> depthFirstTraverseStack, String currentNode, Node node) {
		return node != null && node.getEdgeList().size() > 0;
	}

	private void addAllConnectedNodesToDFTStack(Stack<String[]> depthFirstTraverseStack, Node node) {
		for (Edge edge : node.getEdgeList())
			depthFirstTraverseStack.push(new String[] { edge.getConnectedNodeName(), edge.getEdgeName() });
	}

	private Map<String, Integer> pathAlongWithDistance(Map<String, Integer> mapOfAllPossiblePathsBtwTwoNodes,
			List<String[]> path) {
		String pathName = "[";
		int totalDistance = 0;
		for (String[] stringArray : path) {
			pathName = pathName + stringArray[0] + ",";
			totalDistance = totalDistance + Integer.valueOf(stringArray[1]);
		}
		mapOfAllPossiblePathsBtwTwoNodes.put(pathName.substring(0, pathName.lastIndexOf(",")) + "]", totalDistance);
		return mapOfAllPossiblePathsBtwTwoNodes;
	}
}