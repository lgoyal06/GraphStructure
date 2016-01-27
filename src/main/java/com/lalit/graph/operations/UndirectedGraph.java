package com.lalit.graph.operations;

import java.util.Iterator;

import com.lalit.graph.elements.version2.Edge;

public interface UndirectedGraph {

	boolean insertUndirectedEdge(String nodeA, String nodeB, String edgeName);

	Iterator<? extends Edge> undirectedEdges();

}
