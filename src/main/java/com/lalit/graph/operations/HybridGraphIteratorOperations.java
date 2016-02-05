package com.lalit.graph.operations;

import java.util.Iterator;

public interface HybridGraphIteratorOperations<E> {

	public Iterator<E> directedEdges();

	public Iterator<E> undirectedEdges();

}