package com.lalit.graph.algorithm;

import java.util.Map;

import com.lalit.graph.directed.Node;

public interface GraphToMapStructureBuilder {

	public Map<String, Node> buildMapStructure(String filePath);

}
