package com.lalit.graph.directed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 *         TODO : Check for the Time complexity of this algorithm
 */
public class ShortestPathFinderUtility {

	public static Map<String, Integer> findAllPossiblePathsBetweenTwoNodes(Map<String, Node> graphNodesMap,
			String startingNode, String destinationNode) {
		Stack<String[]> depthFirstTraverseStack = new Stack<String[]>();
		depthFirstTraverseStack.push(new String[] { startingNode, "0" });
		Stack<String[]> buildPathStack = new Stack<String[]>();
		Map<String, Integer> mapOfAllPossiblePathsBtwTwoNodes = new HashMap<>();
		while (depthFirstTraverseStack.size() > 0) {
			String[] currentNodeInfo = depthFirstTraverseStack.peek();
			if (currentNodeInfo[0].equalsIgnoreCase(destinationNode)) {
				addNewPathToPossiblePathsList(depthFirstTraverseStack, buildPathStack,
						mapOfAllPossiblePathsBtwTwoNodes);
			} else {
				if (buildPathStack.size() > 0 && currentNodeInfo[0].equalsIgnoreCase(buildPathStack.peek()[0])) {
					depthFirstTraverseStack.pop();
					buildPathStack.pop();
				} else {
					Node node = graphNodesMap.get(currentNodeInfo[0]);
					if (isEgdeExistsForCurrentNode(depthFirstTraverseStack, currentNodeInfo[0], node)) {
						addAllConnectedNodesToDFTStack(depthFirstTraverseStack, node);
						buildPathStack.push(currentNodeInfo);
					} else {
						depthFirstTraverseStack.pop();
					}
				}
			}
		}
		return mapOfAllPossiblePathsBtwTwoNodes;
	}

	private static void addNewPathToPossiblePathsList(Stack<String[]> depthFirstTraverseStack,
			Stack<String[]> buildPathStack, Map<String, Integer> mapOfAllPossiblePathsBtwTwoNodes) {
		buildPathStack.push(depthFirstTraverseStack.pop());
		List<String[]> listDeepCopy = CommonUtility.deepCopyOfList(buildPathStack.list());
		pathAlongWithDistance(mapOfAllPossiblePathsBtwTwoNodes, listDeepCopy);
		buildPathStack.pop();
	}

	private static boolean isNodeAlreadyExistInDFTStack(Stack<String[]> depthFirstTraverseStack, String currentNode) {
		if (depthFirstTraverseStack.size() == 1) {
			return false;
		}
		return CommonUtility.isDuplicateElementInStringArrayList(depthFirstTraverseStack.list(), currentNode);
	}

	private static boolean isEgdeExistsForCurrentNode(Stack<String[]> depthFirstTraverseStack, String currentNode,
			Node node) {
		return node != null && !isNodeAlreadyExistInDFTStack(depthFirstTraverseStack, currentNode)
				&& node.getEdgeList().size() > 0;
	}

	private static void addAllConnectedNodesToDFTStack(Stack<String[]> depthFirstTraverseStack, Node node) {
		for (Edge edge : node.getEdgeList()) {
			depthFirstTraverseStack.push(new String[] { edge.getConnectedNodeName(), edge.getEdgeName() });
		}
	}

	private static Map<String, Integer> pathAlongWithDistance(Map<String, Integer> mapOfAllPossiblePathsBtwTwoNodes,
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