package com.lalit.graph.operations;

import java.util.Iterator;
import java.util.Map;

import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.elements.version2.Node;

public interface GraphIterator {

	Iterator<? extends Edge> directedEdges();

	Iterator<? extends Edge> inIncidentEdges(String nodeNameId);

	Iterator<? extends Edge> outIncidentEdges(String nodeNameId);

	Iterator<? extends Map<String, ? extends Node>> inAdjacentNodes(String nodeNameId);

	Iterator<? extends Map<String, ? extends Node>> outAdjacentNodes(String nodeNameId);

}