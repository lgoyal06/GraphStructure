package com.lalit.graph.elements.version2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lalit goyal
 * 
 *         This is like the Facebook Contact or individual user each of these
 *         can have the contact, personal information section
 */
public class Node {

	private String nodeName;
	private List<String> incomingEdgeList;
	private List<String> outGoingEdgeList;
	private List<String> undirectedEdgeList;

	public List<String> getUndirectedEdgeList() {
		// Singleton Pattern means one time initialization per instance of the
		// Node class Object
		if (undirectedEdgeList == null)
			return new ArrayList<>();
		else
			return undirectedEdgeList;
	}

	public void setUndirectedEdgeList(List<String> undirectedEdgeList) {
		this.undirectedEdgeList = undirectedEdgeList;

	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public List<String> getIncomingEdgeList() {
		// Singleton Pattern means one time initialization per instance of the
		// Node class Object
		if (incomingEdgeList == null)
			return new ArrayList<>();
		else
			return incomingEdgeList;
	}

	public void setIncomingEdgeList(List<String> incomingEdgeList) {
		this.incomingEdgeList = incomingEdgeList;
	}

	public List<String> getOutGoingEdgeList() {
		// Singleton Pattern means one time initialization per instance of the
		// Node class Object
		if (outGoingEdgeList == null)
			return new ArrayList<>();
		else
			return outGoingEdgeList;
	}

	public void setOutGoingEdgeList(List<String> outGoingEdgeList) {
		this.outGoingEdgeList = outGoingEdgeList;
	}

	public void setOutGoingEdgeToList(String outGoingEdge) {
		this.outGoingEdgeList = getOutGoingEdgeList();
		this.outGoingEdgeList.add(outGoingEdge);
	}

	public void setIncomingEdgeToList(String incomingEdge) {
		this.incomingEdgeList = getIncomingEdgeList();
		this.incomingEdgeList.add(incomingEdge);
	}

	public void setUndirectedEdgeToList(String undirectedEdge) {
		this.undirectedEdgeList = getUndirectedEdgeList();
		this.undirectedEdgeList.add(undirectedEdge);
	}

}