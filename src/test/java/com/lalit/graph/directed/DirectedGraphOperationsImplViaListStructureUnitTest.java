package com.lalit.graph.directed;

import org.junit.Ignore;

import com.lalit.directed.graph.operations.DirectedGraphImpl;

public class DirectedGraphOperationsImplViaListStructureUnitTest {

	@Ignore
	public void givenEmptyGraphWhenInsertNodePrformedThenExpectGraphUpdatedWithNode() {

		// TODO: Fix it
		DirectedGraphImpl graph = new DirectedGraphImpl();
		graph.insertNode("A");
		graph.insertNode("B");
		graph.insertNode("E");
		graph.insertDirectedEdge("B", "A", "Test");
		graph.insertDirectedEdge("C", "A", "EdgeFromCToA");
		graph.insertDirectedEdge("B", "C", "EdgeFromBToC");
		graph.insertUndirectedEdge("B", "D", "UndirectedEdgeFromBToD");

		System.out.println(graph);

		graph.deleteNode("B");
		graph.deleteNode("C");
		graph.deleteEdge("EdgeFromCToA");

		System.out.println(graph);

	}

}