package com.graph.undirected;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GraphToMapStructureBuilderImpl implements GraphToMapStructureBuilder {

	/**
	 * 
	 * Algorithm should work for the Directed Graph
	 **/
	public Map<String, Node<Edge>> buildMapStructure(String filePath) {
		BufferedReader reader = null;
		FileInputStream fis = null;
		Map<String, Node<Edge>> graph = new TreeMap<String, Node<Edge>>();
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
					Node<Edge> node = null;
					if (graph.get(splitter[1]) == null) {
						node = new Node<Edge>();
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