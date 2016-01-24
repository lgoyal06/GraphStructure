package com.lalit.graph.utility;

import java.util.ArrayList;
import java.util.List;

import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.elements.version2.Node;

/**
 * @author lalit goyal
 * 
 *         Check how this structure is better than Map Structure And target to
 *         achieve insert,delete,update in O(n)
 * 
 * 
 */
public class GraphToEdgeNodeListBuilder {
	List<Edge> list = new ArrayList<Edge>();
	List<Node> nodeList = new ArrayList<Node>();

	public List<Edge> getList() {
		return list;
	}

	public void setList(List<Edge> list) {
		this.list = list;
	}

	public List<Node> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<Node> nodeList) {
		this.nodeList = nodeList;
	}
}