package com.lalit.undirected.Graph.operations;

import java.util.Iterator;

import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.operations.GraphImpl;

/**
 * @author lalit goyal
 * @param fromNodeName
 * @param toNodeName
 * @param edgeName
 * @return
 * 
 */
public class UndirectedGraph extends GraphImpl implements UndirectedGraphCRUDOperations, UndirectedGraphIterator {

	@Override
	public Iterator<? extends Edge> incidentEdges(String nodeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<? extends Edge> undirectedEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertUndirectedEdge(String nodeAName, String nodeBName, String edgeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int degree(String nodeNameId) {
		// TODO Auto-generated method stub
		return 0;
	}
}