package com.lalit.graph.operations;

import java.util.Iterator;

public interface HybridGraphIteratorOperations<E> {

	Iterator<E> directedEdges();

	Iterator<E> undirectedEdges();

}