package com.lalit.graph.utility;

import java.util.Map;

import com.lalit.graph.elements.Node;

public interface GraphToMapStructureBuilder {

	Map<String, Node> buildMapStructure(String filePath);

}
