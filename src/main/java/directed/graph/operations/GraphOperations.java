package directed.graph.operations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.lalit.graph.elements.Edge;

public class GraphOperations {

	Map<String, Set<Edge>> graphMap = new TreeMap<>();

	// TODO Graph Add Operation
	private boolean addOperation(String fromNodeName, String toNodeName, String edgeName) {
		try {
			if (!graphMap.containsKey(fromNodeName)) {
				graphMap.put(fromNodeName, null);
			}
			if (toNodeName != null && !toNodeName.equalsIgnoreCase("")) {
				Edge edge = new Edge(edgeName, toNodeName);
				Set<Edge> edgeSet = graphMap.get(fromNodeName) == null ? new HashSet<Edge>()
						: graphMap.get(fromNodeName);
				edgeSet.add(edge);
				graphMap.put(fromNodeName, edgeSet);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String... s) {
		GraphOperations graphOperation = new GraphOperations();
		graphOperation.addOperation("A", "B", "");
		graphOperation.addOperation("B", "C", "");
		graphOperation.addOperation("C", "A", "");
		graphOperation.addOperation("A", "B", "HELLO");
		graphOperation.addOperation("C", "D", "HELLO");
		for (String key : graphOperation.graphMap.keySet()) {
			Iterator<Edge> it = graphOperation.graphMap.get(key).iterator();
			System.out.println(key + " Friend List::");
			while (it.hasNext()) {
				Edge edge = it.next();
				System.out.println("\t" + edge.getConnectedNodeName());
			}
		}
	}

}
