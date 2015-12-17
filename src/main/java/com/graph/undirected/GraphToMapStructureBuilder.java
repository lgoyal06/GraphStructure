package com.graph.undirected;

import java.util.Map;

public interface GraphToMapStructureBuilder {

	public Map<String, Node<Edge>> buildMapStructure(String filePath);

}
