package com.lalit.directed.graph.operations;

import java.util.Iterator;
import java.util.Map.Entry;

public interface DirectedGraphIteratorOperation<N, E> {

	Iterator<E> inIncidentEdges(String nodeName);

	Iterator<E> outIncidentEdges(String nodeName);

	Iterator<Entry<String, N>> inAdjacentNodes(String nodeName);

	Iterator<Entry<String, N>> outAdjacentNodes(String nodeName);

}