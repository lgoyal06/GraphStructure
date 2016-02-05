package com.lalit.graph.operations;

import java.util.Iterator;
import java.util.Map.Entry;

public interface GraphIteratorOperations<N, E> {

	Iterator<Entry<String, N>> adjacentNodes(String nodeName);

	Iterator<Entry<String, N>> nodes();

	Iterator<E> edges();

	Iterator<E> incidentEdges(String nodeName);

}