package com.lalit.graph.directed;

import java.util.Map;

import org.junit.Test;

import com.lalit.directed.graph.algorithm.GraphToMapStructureBuilder;
import com.lalit.directed.graph.algorithm.GraphToMapStructureBuilderImpl;
import com.lalit.directed.graph.algorithm.ShortestPathFinderAlgorithm;
import com.lalit.graph.elements.Node;

//github.com/lgoyal06/GraphStructureAlgorithms.git

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ShortestPathFinderUtilityUnitTest {

	@Test
	public void positiveTest() {
		GraphToMapStructureBuilder mapBuilder = new GraphToMapStructureBuilderImpl();
		Map<String, Node> map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructureAlgorithms\\src\\test\\resources\\SampleInputFile2");
		int expectedResult = 11;
		Map<String, Integer> listOfPathsBetweenTwoNodes = ShortestPathFinderAlgorithm
				.findAllPossiblePathsBetweenTwoNodes(map, "S", "T");
		System.out.println(listOfPathsBetweenTwoNodes);
		Assert.assertEquals(expectedResult, listOfPathsBetweenTwoNodes.size());
	}

}