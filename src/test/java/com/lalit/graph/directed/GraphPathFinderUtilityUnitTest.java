package com.lalit.graph.directed;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.lalit.directed.graph.algorithm.DijkstraAlgorithmImplementation;
import com.lalit.directed.graph.algorithm.GraphPathFinderAlgorithm;
import com.lalit.directed.graph.builder.DirectedGraphToMapStructureBuilderImpl;
import com.lalit.graph.builder.GraphToMapStructureBuilder;
import com.lalit.graph.elements.Node;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class GraphPathFinderUtilityUnitTest {

	@Test
	public void positiveTestToFindAllPossiblePathBetweenTwoNodes() {
		GraphToMapStructureBuilder mapBuilder = new DirectedGraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructure\\src\\test\\resources\\SampleInputFile2");
		int expectedNumberOfPathsBetweenTwoNodes = 11;
		Map<String, Integer> listOfPathsBetweenTwoNodes = new GraphPathFinderAlgorithm()
				.findAllPossiblePathsBetweenTwoNodes(map, "S", "T");
		Assert.assertEquals(expectedNumberOfPathsBetweenTwoNodes, listOfPathsBetweenTwoNodes.size());
	}

	@Test
	public void positiveTest1ToFindShortestPathBetweenTwoNodesWhenMultiplePathsExists() {
		GraphToMapStructureBuilder mapBuilder = new DirectedGraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructure\\src\\test\\resources\\SampleInputFile2");
		String expectedPath = "[S,D,T]";
		int expectedDistance = 10;
		Map<String, Integer> listOfPathsBetweenTwoNodes = new GraphPathFinderAlgorithm()
				.findShortestPathAndDistanceBtwTwoNodesInDirectedGraph(map, "S", "T");
		for (Entry<String, Integer> entry : listOfPathsBetweenTwoNodes.entrySet()) {
			Assert.assertEquals(expectedDistance, (int) entry.getValue());
			Assert.assertEquals(expectedPath, entry.getKey());
			break;
		}
	}

	@Test
	public void positiveTest2ToFindShortestPathBetweenTwoNodesWhenOnePathExists() {
		GraphToMapStructureBuilder mapBuilder = new DirectedGraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructure\\src\\test\\resources\\SampleInputFile2");
		String expectedPath = "[S,A]";
		int expectedDistance = 4;
		Map<String, Integer> listOfPathsBetweenTwoNodes = new GraphPathFinderAlgorithm()
				.findShortestPathAndDistanceBtwTwoNodesInDirectedGraph(map, "S", "A");
		for (Entry<String, Integer> entry : listOfPathsBetweenTwoNodes.entrySet()) {
			Assert.assertEquals(expectedDistance, (int) entry.getValue());
			Assert.assertEquals(expectedPath, entry.getKey());
			break;
		}
	}

	@Test
	public void positiveTest3ToFindShortestPathBetweenTwoNodesWhenNoPathExists() {
		GraphToMapStructureBuilder mapBuilder = new DirectedGraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructure\\src\\test\\resources\\SampleInputFile2");
		String expectedPath = "";
		int expectedDistance = -1;
		Map<String, Integer> listOfPathsBetweenTwoNodes = new GraphPathFinderAlgorithm()
				.findShortestPathAndDistanceBtwTwoNodesInDirectedGraph(map, "S", "A1");
		for (Entry<String, Integer> entry : listOfPathsBetweenTwoNodes.entrySet()) {
			Assert.assertEquals(expectedDistance, (int) entry.getValue());
			Assert.assertEquals(expectedPath, entry.getKey());
			break;
		}
	}

	@Test
	public void positiveTest1ToFindAllPossiblePathBetweenTwoNodes() {
		GraphToMapStructureBuilder mapBuilder = new DirectedGraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructure\\src\\test\\resources\\SampleInputFile3");
		int expectedNumberOfPathsBetweenTwoNodes = 5;
		String[] paths = new String[] { "[A,B,D,K]", "[A,B,E,K]", "[A,B,D,E,K]", "[A,B,E,F,K]", "[A,B,D,E,F,K]" };
		int[] pathDistance = new int[] { 14, 15, 16, 19, 20 };
		Map<String, Integer> listOfPathsBetweenTwoNodes = new GraphPathFinderAlgorithm()
				.findAllPossiblePathsBetweenTwoNodes(map, "A", "K");
		Assert.assertEquals(expectedNumberOfPathsBetweenTwoNodes, listOfPathsBetweenTwoNodes.size());
		int count = 0;
		for (Entry<String, Integer> entry : listOfPathsBetweenTwoNodes.entrySet()) {
			Assert.assertEquals(pathDistance[count], (int) entry.getValue());
			Assert.assertEquals(paths[count], entry.getKey());
			++count;
		}
	}

	@Test
	public void positiveTestDijkstrasAlgoToFindShortestPathBetweenTwoNodes() {
		GraphToMapStructureBuilder mapBuilder = new DirectedGraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructure\\src\\test\\resources\\SampleInputFile2");
		String expectedShortestPath = "S,A,C,E,G,T";
		String expectedShortestPathWeight = "11";
		String[] shortestPathAndWeight = new DijkstraAlgorithmImplementation().findShortestPathBetweenTwoNodes(map, "S",
				"T");
		Assert.assertEquals(expectedShortestPath, shortestPathAndWeight[0]);
		Assert.assertEquals(expectedShortestPathWeight, shortestPathAndWeight[1]);
	}

}