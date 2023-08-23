package com.agt.app.reclyclebin;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Question4 {

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<>();
		
		arr.add(5);
		arr.add(5);
		arr.add(4);
		arr.add(3);
		arr.add(2);
		arr.add(1);
		

		System.out.println(find3rdSmallest_DuplicatesAllowed(arr, arr.size()));

	}

	private static int find3rdSmallest_DuplicatesAllowed(List<Integer> arr, int size) {

		int temp, min;

		for (int i = 0; i < arr.size(); i++) {

			min = arr.get(i);

			for (int j = i; j < arr.size(); j++) {

				if (arr.get(i) > arr.get(j)) {

					temp = arr.get(i);

					arr.set(i, arr.get(j));

					arr.set(j, temp);

				}

			}

		}

		return arr.get(2);

	}
	
}
