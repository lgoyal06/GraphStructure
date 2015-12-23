package com.lalit.graph.directed;

import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ShortestPathFinderUtilityUnitTest {

	@Test
	public void positiveTest() {
		GraphToMapStructureBuilder mapBuilder = new GraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructureAlgorithms\\src\\test\\resources\\SampleInputFile2");
		int expectedResult = 11;
		Map<String, Integer> listOfPathsBetweenTwoNodes = ShortestPathFinderUtility
				.findAllPossiblePathsBetweenTwoNodes(map, "S", "T");
		Assert.assertEquals(expectedResult, listOfPathsBetweenTwoNodes.size());
	}

}