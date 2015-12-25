package com.lalit.graph.directed;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.lalit.directed.graph.algorithm.ShortestPathFinderAlgorithm;
import com.lalit.graph.elements.Node;
import com.lalit.graph.utility.GraphToMapStructureBuilder;
import com.lalit.graph.utility.GraphToMapStructureBuilderImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ShortestPathFinderUtilityUnitTest {

	@Test
	public void positiveTestToFindAllPossiblePathBetweenTwoNodes() {
		GraphToMapStructureBuilder mapBuilder = new GraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructureAlgorithms\\src\\test\\resources\\SampleInputFile2");
		int expectedNumberOfPathsBetweenTwoNodes = 11;
		Map<String, Integer> listOfPathsBetweenTwoNodes = ShortestPathFinderAlgorithm
				.findAllPossiblePathsBetweenTwoNodes(map, "S", "T");
		Assert.assertEquals(expectedNumberOfPathsBetweenTwoNodes, listOfPathsBetweenTwoNodes.size());
	}

	@Test
	public void positiveTest1ToFindShortestPathBetweenTwoNodesWhenMultiplePathsExists() {
		GraphToMapStructureBuilder mapBuilder = new GraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructureAlgorithms\\src\\test\\resources\\SampleInputFile2");
		String expectedPath = "[S,D,T]";
		int expectedDistance = 10;
		Map<String, Integer> listOfPathsBetweenTwoNodes = ShortestPathFinderAlgorithm
				.findShortestPathAndDistanceBtwTwoNodesInDirectedGraph(map, "S", "T");
		for (Entry<String, Integer> entry : listOfPathsBetweenTwoNodes.entrySet()) {
			Assert.assertEquals(expectedDistance, (int) entry.getValue());
			Assert.assertEquals(expectedPath, entry.getKey());
			break;
		}
	}

	@Test
	public void positiveTest2ToFindShortestPathBetweenTwoNodesWhenOnePathExists() {
		GraphToMapStructureBuilder mapBuilder = new GraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructureAlgorithms\\src\\test\\resources\\SampleInputFile2");
		String expectedPath = "[S,A]";
		int expectedDistance = 4;
		Map<String, Integer> listOfPathsBetweenTwoNodes = ShortestPathFinderAlgorithm
				.findShortestPathAndDistanceBtwTwoNodesInDirectedGraph(map, "S", "A");
		for (Entry<String, Integer> entry : listOfPathsBetweenTwoNodes.entrySet()) {
			Assert.assertEquals(expectedDistance, (int) entry.getValue());
			Assert.assertEquals(expectedPath, entry.getKey());
			break;
		}
	}

	@Test
	public void positiveTest3ToFindShortestPathBetweenTwoNodesWhenNoPathExists() {
		GraphToMapStructureBuilder mapBuilder = new GraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructureAlgorithms\\src\\test\\resources\\SampleInputFile2");
		String expectedPath = "";
		int expectedDistance = -1;
		Map<String, Integer> listOfPathsBetweenTwoNodes = ShortestPathFinderAlgorithm
				.findShortestPathAndDistanceBtwTwoNodesInDirectedGraph(map, "S", "A1");
		for (Entry<String, Integer> entry : listOfPathsBetweenTwoNodes.entrySet()) {
			Assert.assertEquals(expectedDistance, (int) entry.getValue());
			Assert.assertEquals(expectedPath, entry.getKey());
			break;
		}
	}
}