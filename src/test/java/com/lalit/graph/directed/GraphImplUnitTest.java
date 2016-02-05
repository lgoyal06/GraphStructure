package com.lalit.graph.directed;

import org.junit.Ignore;

import com.lalit.graph.operations.HybridGraph;

public class GraphImplUnitTest {

	@Ignore
	public void givenEmptyGraphWhenInsertNodePrformedThenExpectGraphUpdatedWithNode() {

		HybridGraph graph = new HybridGraph();
		graph.insertNode("A");
		graph.insertNode("B");
		graph.insertNode("E");
		graph.insertEdge("B", "A", "Test");
		graph.insertEdge("C", "A", "EdgeFromCToA");
		graph.insertEdge("B", "C", "EdgeFromBToC");
		graph.insertEdge("B", "D", "UndirectedEdgeFromBToD");
		graph.insertEdge("E", "D", "EdgeFromEToD");

		System.out.println(graph);

		graph.deleteNode("B");
		graph.deleteNode("C");
		graph.deleteEdge("EdgeFromCToA");
		graph.reverseDirection("EdgeFromEToD");
		System.out.println(graph);

	}

	public static void main(String... s) {
		HybridGraph graph = new HybridGraph();
		graph.insertNode("A");
		graph.insertNode("B");
		graph.insertNode("E");
		graph.insertEdge("B", "A", "EdgeFromBToA");
		graph.insertEdge("C", "A", "EdgeFromCToA");
		graph.insertEdge("B", "C", "EdgeFromBToC");
		graph.insertEdge("B", "D", "UndirectedEdgeFromBToD");
		graph.insertEdge("E", "D", "EdgeFromEToD");
		graph.insertEdge("F", "G", "EdgeFromFToG");
		graph.insertEdge("F", "A", "UndirectedEdgeFromFToA");

		System.out.println(graph);

		graph.deleteNode("B");
		graph.deleteNode("C");
		graph.deleteEdge("EdgeFromCToA");
		graph.reverseDirection("EdgeFromEToD");
		graph.setDirectionFrom("EdgeFromEToD", "L");
		graph.setDirectionTo("EdgeFromEToD", "K");
		System.out.println(graph);
	}
}