package com.lalit.directed.graph.algorithm;

import java.util.Map;

import com.lalit.graph.elements.Edge;
import com.lalit.graph.elements.Node;
import com.lalit.graph.utility.Queue;

/**
 * @author lalit goyal
 * 
 *         TODO 26th Dec 2015
 *
 */
public final class DijkstraAlgorithmImplementation {

	public String[] findShortestPathBetweenTwoNodes(Map<String, Node> graphMap, String startingNode,
			String destinationNode) {
		Queue queueToMaintainNodes = new Queue();
		queueToMaintainNodes.push(startingNode, "0");
		while (queueToMaintainNodes.size() > 0) {
			String currentProcessingNode = queueToMaintainNodes.peek();
			if (currentProcessingNode.equals(destinationNode)) {
				return new String[] { queueToMaintainNodes.getValueOfNode(currentProcessingNode)[0],
						queueToMaintainNodes.getValueOfNode(currentProcessingNode)[1] };
			}
			Node node = graphMap.get(currentProcessingNode);
			if (node != null && node.getEdgeList().size() > 0) {
				addAllConnectedNodesToQueue(queueToMaintainNodes, node, currentProcessingNode);
			}
			queueToMaintainNodes.pop(currentProcessingNode);
		}
		return null;
	}

	private void addAllConnectedNodesToQueue(Queue queueToMaintainNodes, Node node, String currentProcessingNode) {
		for (Edge edge : node.getEdgeList())
			queueToMaintainNodes.push(edge.getConnectedNodeName(), Integer.valueOf(edge.getEdgeName()),
					currentProcessingNode);
	}
}