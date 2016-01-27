package com.lalit.graph.operations;

import com.lalit.graph.elements.version2.Edge;

public interface DirectedGraph extends GraphIterator {

	boolean insertDirectedEdge(String fromNodeName, String toNodeName, String edgeName);

	boolean makeUndirected(String edgeName);

	boolean reverseDirection(String edgeName);

	boolean setDirectionFrom(String edgeName, String newFromNodeName);

	boolean setDirectionTo(String edgeName, String newToNodeName);

	Edge destination(String edgeName);

	Edge origin(String edgeName);

	int inDegree(String nodeNameId);

	int outDegree(String nodeNameId);

	}