package com.lalit.graph.directed;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ShortestPathFinderUtilityUnitTest {

	@Test
	public void positiveTest() {
		GraphToMapStructureBuilder mapBuilder = new GraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructureLearning\\src\\test\\resources\\SampleInputFile");
		String expectedResult = "[Reno,Chicago,Miami,]";
		Assert.assertEquals(expectedResult,
				ShortestPathFinderUtility.findAllPossiblePathsBetweenTwoNodes(map, "Reno", "Miami").toString());
	}
}