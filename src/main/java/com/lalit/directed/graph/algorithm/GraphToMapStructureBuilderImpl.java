package com.lalit.directed.graph.algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.lalit.graph.elements.Edge;
import com.lalit.graph.elements.Node;

public class GraphToMapStructureBuilderImpl implements GraphToMapStructureBuilder {

	/**
	 * 
	 * Algorithm should work for the Directed Graph.
	 * 
	 * Algorithm converts
	 * 
	 * Input data format [Distance,Node A,Node B]
	 * 
	 * Output Format-> Map with <Key name of Node N , Value as List Of All Edges
	 * Connecting to that Node N>
	 * 
	 * TODO : Check for the Time complexity of this algorithm
	 **/
	public Map<String, Node> buildMapStructure(String filePath) {
		BufferedReader reader = null;
		FileInputStream fis = null;
		Map<String, Node> graph = new TreeMap<String, Node>();
		try {
			fis = new FileInputStream(filePath);
			reader = new BufferedReader(new InputStreamReader(fis));
			String lineData = null;
			int counter = 0;
			List<Edge> edgeList = null;
			while (counter == 0 || lineData != null) {
				lineData = reader.readLine();
				if (lineData == null) {
					continue;
				} else {
					String splitter[] = lineData.split(",");
					Node node = null;
					if (graph.get(splitter[1]) == null) {
						node = new Node();
						edgeList = node.getEdgeList();
						Edge e = new Edge(splitter[0]);
						e.setConnectedNodeName(splitter[2]);
						edgeList.add(e);
						node.setEdgeList(edgeList);
						graph.put(splitter[1], node);
					} else {
						node = graph.get(splitter[1]);
						edgeList = node.getEdgeList();
						Edge e = new Edge(splitter[0]);
						e.setConnectedNodeName(splitter[2]);
						edgeList.add(e);
						node.setEdgeList(edgeList);
					}
				}
				++counter;
			}
			return graph;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}