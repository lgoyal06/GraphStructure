package com.lalit.directed.graph.algorithm;

import java.util.Map;

import com.lalit.graph.elements.Node;

public interface GraphToMapStructureBuilder {

	public Map<String, Node> buildMapStructure(String filePath);

}
