package com.lalit.undirected.Graph.operations;

import java.util.Iterator;

import com.lalit.graph.elements.version2.Edge;

public interface UndirectedGraphIterator {

	Iterator<? extends Edge> incidentEdges(String nodeName);

	Iterator<? extends Edge> undirectedEdges();

}