package com.lalit.graph.directed;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.lalit.directed.graph.builder.DirectedGraphToMapStructureBuilderImpl;
import com.lalit.graph.elements.Edge;
import com.lalit.graph.elements.Node;
import com.lalit.graph.utility.GraphToMapStructureBuilder;

/**
 * @author lalit goyal
 * 
 *         This is the Graph search sample for searching the following query
 * 
 *         Query : find flight from CityA to CityB
 *
 */
public class GraphSearchSample {

	Map<String, Node> map;

	public GraphSearchSample() {
		GraphToMapStructureBuilder mapBuilder = new DirectedGraphToMapStructureBuilderImpl();
		map = mapBuilder.buildMapStructure(
				"C:\\Users\\lalit goyal\\git\\GraphStructureAlgorithms\\src\\test\\resources\\SampleInputFile4");
	}

	public static void main(String... s) {

		GraphSearchSample sample = new GraphSearchSample();
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter what you want to search");
		String query = in.nextLine();
		String[] locations = sample.findFromToLocation(query);
		System.out.println(sample.getFlightNumber(locations[0], locations[1]));

	}

	private String[] findFromToLocation(String query) {

		int fromIndex = query.toUpperCase().indexOf("FROM");
		int toIndex = query.toUpperCase().indexOf("TO");

		String fromCity = query.substring(fromIndex, toIndex);
		String toCity = query.substring(toIndex);

		String exactFromCity = getExactLocation(fromCity.toUpperCase());
		String exactToCity = getExactLocation(toCity.toUpperCase());

		return new String[] { exactFromCity, exactToCity };
	}

	private String getExactLocation(String fromCity) {
		Iterator<String> it = this.map.keySet().iterator();
		while (it.hasNext()) {
			String text = it.next().toUpperCase();
			if (fromCity.indexOf(text.toUpperCase()) != -1)
				return text;
		}
		return null;
	}

	private String getFlightNumber(String fromCity, String toCity) {

		Iterator<Edge> it = this.map.get(fromCity).getEdgeList().iterator();
		while (it.hasNext()) {
			Edge e = it.next();
			if (e.getConnectedNodeName().equals(toCity)) {
				return e.getEdgeName();
			}
		}

		return null;

	}
}
