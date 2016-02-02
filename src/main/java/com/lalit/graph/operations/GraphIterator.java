package com.lalit.graph.operations;

import java.util.Iterator;
import java.util.Map.Entry;

import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.elements.version2.Node;

public interface GraphIterator {

	Iterator<? extends Edge> incidentEdges(String nodeName);

	Iterator<Entry<String, Node>> adjacentNodes(String nodeName);

	Iterator<Entry<String, Node>> nodes();

	Iterator<? extends Edge> edges();

}