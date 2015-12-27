package com.lalit.graph.utility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Queue {
	private Map<String, String[]> nodeMap = new HashMap<String, String[]>();
	private List<String> processedNodesList = new ArrayList<>();

	public void pop(String node) {
		processedNodesList.add(node);
		nodeMap.remove(node);
	}

	public String[] getValueOfNode(String node) {
		return nodeMap.get(node);
	}

	public String peek() {
		ValueComparator vc = new ValueComparator();
		Map<String, String[]> sortedNodeMap = new TreeMap<String, String[]>(vc);
		sortedNodeMap.putAll(nodeMap);
		for (Map.Entry<String, String[]> entry : sortedNodeMap.entrySet()) {
			return entry.getKey();
		}
		return null;
	}

	public void push(String nodeWaitingToBePushed, Integer weightFromWaitingNodeToCurrentProcessingNode,
			String currentProcessingNode) {
		int weightCurrentProcessingNodeToStartingNode = Integer.valueOf(this.nodeMap.get(currentProcessingNode)[1]);
		int weightFromWaitingNodeToStartingNodeViaCurrentProcessingNode = weightFromWaitingNodeToCurrentProcessingNode
				+ weightCurrentProcessingNodeToStartingNode;
		String pathCurrentProcessingNodeToStartingNode = this.nodeMap.get(currentProcessingNode)[0];
		if (this.nodeMap.containsKey(nodeWaitingToBePushed)
				&& weightFromWaitingNodeToStartingNodeViaCurrentProcessingNode > Integer
						.valueOf(this.nodeMap.get(nodeWaitingToBePushed)[1])) {
			this.nodeMap.put(nodeWaitingToBePushed,
					new String[] { pathCurrentProcessingNodeToStartingNode + "," + nodeWaitingToBePushed,
							String.valueOf(weightFromWaitingNodeToStartingNodeViaCurrentProcessingNode) });
		} else if (!processedNodesList.contains(nodeWaitingToBePushed)) {
			this.nodeMap.put(nodeWaitingToBePushed,
					new String[] { pathCurrentProcessingNodeToStartingNode + "," + nodeWaitingToBePushed,
							String.valueOf(weightFromWaitingNodeToStartingNodeViaCurrentProcessingNode) });
		}
	}

	public void push(String nodeWaitingToBePushed, String weight) {
		this.nodeMap.put(nodeWaitingToBePushed, new String[] { nodeWaitingToBePushed, weight });
	}

	public int size() {
		return nodeMap.size();
	}

	private final class ValueComparator implements Comparator<String> {

		public int compare(String a, String b) {
			if (Integer.valueOf(nodeMap.get(a)[1]) >= Integer.valueOf(nodeMap.get(b)[1])) {
				return 1;
			}
			return -1;
		}
	}
}