package com.lalit.graph.directed;

import java.util.ArrayList;
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

	public static List<List<String[]>> findAllPossiblePathsBetweenTwoNodes(Map<String, Node> graphNodesMap,
			String startingNode, String destinationNode) {
		Stack<String[]> depthFirstTraverseStack = new Stack<String[]>();
		depthFirstTraverseStack.push(new String[] { startingNode, "0" });
		Stack<String[]> buildPathStack = new Stack<String[]>();
		List<List<String[]>> allPossiblePathsBtwTwoNodes = new ArrayList<>();
		while (depthFirstTraverseStack.size() > 0) {
			String[] currentNodeInfo = depthFirstTraverseStack.peek();
			if (currentNodeInfo[0].equalsIgnoreCase(destinationNode)) {
				addNewPathToPossiblePathsList(depthFirstTraverseStack, buildPathStack, allPossiblePathsBtwTwoNodes);
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
		return allPossiblePathsBtwTwoNodes;
	}

	private static void addNewPathToPossiblePathsList(Stack<String[]> depthFirstTraverseStack,
			Stack<String[]> buildPathStack, List<List<String[]>> allPossiblePathsBtwTwoNodes) {
		buildPathStack.push(depthFirstTraverseStack.pop());
		List<String[]> listDeepCopy = CommonUtility.deepCopyOfList(buildPathStack.list());
		allPossiblePathsBtwTwoNodes.add(listDeepCopy);
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

	public static void printAllPossiblePathWithDistance(List<List<String[]>> listOfPathsBetweenTwoNodes) {
		for (List<String[]> list : listOfPathsBetweenTwoNodes) {
			String pathName = "";
			int totalDistance = 0;
			for (String[] stringArray : list) {
				pathName = pathName + stringArray[0] + "->";
				totalDistance = totalDistance + Integer.valueOf(stringArray[1]);
			}
			System.out.println(pathName + "Distance->" + totalDistance);
		}
	}
}