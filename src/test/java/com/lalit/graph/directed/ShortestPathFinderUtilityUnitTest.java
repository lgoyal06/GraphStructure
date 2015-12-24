package com.lalit.graph.directed;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.lalit.directed.graph.algorithm.GraphToMapStructureBuilder;
import com.lalit.directed.graph.algorithm.GraphToMapStructureBuilderImpl;
import com.lalit.directed.graph.algorithm.ShortestPathFinderAlgorithm;
import com.lalit.graph.elements.Node;

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
	public void positiveTestToFindShortestPathBetweenTwoNodes() {
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
}