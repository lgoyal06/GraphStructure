package com.lalit.graph.directed;

import java.util.List;

public class CommonUtility {

	public static boolean isDuplicateElement(List<String> list, String element) {
		boolean isElementFound = false;
		for (String elem : list) {
			if (element.equalsIgnoreCase(elem)) {
				if (isElementFound)
					return true;
				else
					isElementFound = true;
			}
		}
		return false;
	}
}