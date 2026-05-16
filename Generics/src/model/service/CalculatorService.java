package model.service;

import java.util.List;

public class CalculatorService  {
	
	public static <T extends Comparable<T>> T max(List<T> list) {
		
		if (list.isEmpty()) {
			throw new IllegalStateException("List can't be empty.");
		}
		
		T max = list.get(0);
		for (T t : list) {
			if (t.compareTo(max) > 0) {
				max = t;
			}
		}
		return max;
	}

}
