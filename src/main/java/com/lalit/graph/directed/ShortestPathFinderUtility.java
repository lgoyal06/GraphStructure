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
 *         Issue : Backtrack and process all connected nodes of the given Node
 *         to find all possible paths
 * 
 *
 */
public class ShortestPathFinderUtility {

	public static List<String> findAllPossiblePathsBetweenTwoNodes(Map<String, Node> graphNodesMap, String startingNode,
			String destinationNode) {
		Stack<String> depthFirstTraverseStack = new Stack<String>();
		depthFirstTraverseStack.push(startingNode);
		Stack<String> buildPathStack = new Stack<String>();
		List<String> allPossiblePathsBtwTwoNodes = new ArrayList<>();
		while (depthFirstTraverseStack.size() > 0) {
			String currentNode = depthFirstTraverseStack.peek();
			if (currentNode.equalsIgnoreCase(destinationNode)) {
				addBuildPathToPossiblePathsList(depthFirstTraverseStack, buildPathStack, allPossiblePathsBtwTwoNodes,
						currentNode);
			} else {
				if (buildPathStack.size() > 0 && currentNode.equalsIgnoreCase(buildPathStack.peek())) {
					depthFirstTraverseStack.pop();
					buildPathStack.pop();
				} else {
					Node node = graphNodesMap.get(currentNode);
					if (isEgdeExistsForNode(depthFirstTraverseStack, currentNode, node)) {
						addConnectedNodesToDFTStack(depthFirstTraverseStack, node);
						buildPathStack.push(currentNode);
					} else {
						depthFirstTraverseStack.pop();
					}
				}
			}
		}
		return allPossiblePathsBtwTwoNodes;
	}

	private static boolean isEgdeExistsForNode(Stack<String> depthFirstTraverseStack, String currentNode, Node node) {
		return node != null && !isNodeAlreadyExistsInDFTStack(depthFirstTraverseStack, currentNode)
				&& node.getEdgeList().size() > 0;
	}

	private static void addConnectedNodesToDFTStack(Stack<String> depthFirstTraverseStack, Node node) {
		for (Edge edge : node.getEdgeList()) {
			depthFirstTraverseStack.push(edge.getConnectedNodeName());
		}
	}

	private static void addBuildPathToPossiblePathsList(Stack<String> depthFirstTraverseStack,
			Stack<String> buildPathStack, List<String> allPossiblePathsBtwTwoNodes, String currentNode) {
		buildPathStack.push(depthFirstTraverseStack.pop());
		allPossiblePathsBtwTwoNodes.add(buildPathStack.toString());
		buildPathStack.pop();
	}

	private static boolean isNodeAlreadyExistsInDFTStack(Stack<String> depthFirstTraverseStack, String currentNode) {
		if (depthFirstTraverseStack.size() == 1) {
			return false;
		}
		return CommonUtility.isDuplicateElement(depthFirstTraverseStack.list(), currentNode);
	}
}