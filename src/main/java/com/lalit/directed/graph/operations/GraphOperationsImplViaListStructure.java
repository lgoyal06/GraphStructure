package com.lalit.directed.graph.operations;

import java.util.ArrayList;
import java.util.List;

import com.lalit.graph.elements.version2.Edge;
import com.lalit.graph.elements.version2.Node;
import com.lalit.graph.operations.GraphOperations;

/**
 * @author lalit goyal
 * @param fromNodeName
 * @param toNodeName
 * @param edgeName
 * @return
 */
public class GraphOperationsImplViaListStructure implements GraphOperations {

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

	@Override
	public boolean insertOperation(String fromNodeName, String toNodeName, String edgeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNodeOperation(String nodeToBeDeleted) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEdgeOperation(String toNodeName, String edgeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateNodeInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEdgeInfo() {
		// TODO Auto-generated method stub
		return false;
	}
}