package com.lalit.graph.builder;

import java.util.Map;

import com.lalit.graph.elements.Node;

public interface GraphToMapStructureBuilder {

	Map<String, Node> buildMapStructure(String filePath);

}
