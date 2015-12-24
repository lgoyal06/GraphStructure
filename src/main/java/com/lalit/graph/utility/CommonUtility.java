package com.lalit.graph.utility;

import java.util.ArrayList;
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

	public static boolean isDuplicateElementInStringArrayList(List<String[]> list, String element) {
		boolean isElementFound = false;
		for (String[] elem : list) {
			if (element.equalsIgnoreCase(elem[0])) {
				if (isElementFound)
					return true;
				else
					isElementFound = true;
			}
		}
		return false;
	}

	public static List<String[]> deepCopyOfList(List<String[]> list) {
		List<String[]> listCopy = new ArrayList<>();
		for (String[] array : list) {
			listCopy.add((String[]) array.clone());
		}
		return listCopy;
	}
}