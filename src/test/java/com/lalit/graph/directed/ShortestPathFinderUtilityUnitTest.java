package com.lalit.graph.directed;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ShortestPathFinderUtilityUnitTest {

	@Test
	public void positiveTest() {
		GraphToMapStructureBuilder mapBuilder = new GraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructureAlgorithms\\src\\test\\resources\\SampleInputFile");
		int expectedResult = 2;
		List<List<String[]>> listOfPathsBetweenTwoNodes = ShortestPathFinderUtility
				.findAllPossiblePathsBetweenTwoNodes(map, "Atlanta", "Houston");
		Assert.assertEquals(expectedResult, listOfPathsBetweenTwoNodes.size());
	}
}