package com.lalit.directed.graph.operations;

import java.util.Iterator;
import java.util.Map.Entry;

import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.elements.version2.Node;

public interface DirectedGraphIteratorOperation {

	Iterator<? extends Edge> directedEdges();

	Iterator<? extends Edge> inIncidentEdges(String nodeName);

	Iterator<? extends Edge> outIncidentEdges(String nodeName);

	Iterator<Entry<String, Node>> inAdjacentNodes(String nodeName);

	Iterator<Entry<String, Node>> outAdjacentNodes(String nodeName);

}