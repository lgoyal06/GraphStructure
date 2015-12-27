package com.lalit.graph.utility;

import java.util.Comparator;
import java.util.Map;

/**
 * @author lalit goyal
 * 
 *         TODO Make this Utility class more generic and ale to handle all other
 *         similar problems
 * 
 *
 */
public final class ValueComparator implements Comparator<String> {

	Map<String, Integer> map;

	public ValueComparator(Map<String, Integer> base) {
		this.map = base;
	}

	public int compare(String a, String b) {
		if (map.get(a) >= map.get(b)) {
			return 1;
		} else {
			return -1;
		}
	}
}